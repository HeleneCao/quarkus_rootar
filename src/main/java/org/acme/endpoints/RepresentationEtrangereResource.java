package org.acme.endpoints;

import org.acme.dto.RepresentationEtrangereDto;
import org.acme.entities.RepresentationEtrangereEntity;
import org.acme.repositories.RepresentationEtrangereRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;
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
    @Path("{idRepEtr}")
    public Response getById(@PathParam("idRepEtr") Integer idRepEtr){
        RepresentationEtrangereDto representationEtrangere = repEtrDtoById(representationEtrangereRepository.findById(idRepEtr));
        return Response.ok(representationEtrangere).build();
    }

    @POST
    @Transactional
    public Response insert(RepresentationEtrangereEntity representationEtrangere){
        if(representationEtrangere == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        representationEtrangereRepository.persist(representationEtrangere);
        return Response.ok(representationEtrangere).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("{idRepEtr}")
    public Response update(@PathParam("idRepEtr") Integer idRepEtr, RepresentationEtrangereEntity representationEtrangere){
        RepresentationEtrangereEntity representationEtrangereEntity = representationEtrangereRepository.findById(idRepEtr);
        representationEtrangereEntity.setLibelleRepresentation(representationEtrangere.getLibelleRepresentation());
        representationEtrangereEntity.setTelephone(representationEtrangere.getTelephone());
        representationEtrangereEntity.setAdresse(representationEtrangere.getAdresse());
        representationEtrangereEntity.setPays(representationEtrangere.getPays());
        representationEtrangereEntity.setVille(representationEtrangere.getVille());
        return  Response.ok(representationEtrangere).build();
    }

    @DELETE
    @Path("/{idRepEtr}")
    @Transactional
    public Response delete(@PathParam("idRepEtr") Integer idRepEtr) {
        representationEtrangereRepository.deleteById(idRepEtr);
        return Response.ok(idRepEtr).build();
    }
}
