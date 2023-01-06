package org.acme.endpoints;

import org.acme.dto.AeroportDto;
import org.acme.dto.RepresentationEtrangereDto;
import org.acme.entities.AeroportEntity;
import org.acme.entities.RepresentationEtrangereEntity;
import org.acme.repositories.RepresentationEtrangereRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

import static org.acme.dto.AeroportDto.aeroportDtoById;
import static org.acme.dto.RepresentationEtrangereDto.repEtrDtoById;

@Path("/representation_etrangere")
@Tag(name="Representation Etrangere")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RepresentationEtrangereResource {
    @Inject
    RepresentationEtrangereRepository representationEtrangereRepository;
    @GET
    @Operation(summary = "Representation Etrangere", description = "get all Representation Etrangere")
    @APIResponse(responseCode = "200", description = "Ok, Representation Etrangere found")
    @APIResponse(responseCode = "204", description = "Representation Etrangere not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<RepresentationEtrangereDto> representationEtrangeresDto= new ArrayList<>();
        for (RepresentationEtrangereEntity representationEtrangere : representationEtrangereRepository.listAll()){
            RepresentationEtrangereDto representationEtrangereDto= new RepresentationEtrangereDto(representationEtrangere);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            representationEtrangereDto.addLinks("all", uriBase);
            representationEtrangereDto.addLinks("self", uriBase +"/"+ representationEtrangere.getIdRepresentation());
            representationEtrangeresDto.add(representationEtrangereDto);
        }
        return Response.ok(representationEtrangeresDto).build();

    }
    @GET
    @Path("{idAeroport}")
    public Response getById(@PathParam("idAeroport") Integer idAeroport){

        return Response.ok(repEtrDtoById(representationEtrangereRepository.findById(idAeroport))).build();
    }
}
