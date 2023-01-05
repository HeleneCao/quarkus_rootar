package org.acme.endpoints;


import org.acme.dto.VilleDto;
import org.acme.entities.VilleEntity;
import org.acme.repositories.VilleRepository;
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

import static org.acme.dto.PaysDto.paysDtoById;
import static org.acme.dto.VilleDto.villeDtoById;

@Path("/Ville")
@Tag(name="ville")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VilleResource {

    @Inject
    VilleRepository villeRepository;

    @GET
    @Operation(summary = "Ville", description = "get all ville")
    @APIResponse(responseCode = "200", description = "Ok, ville found")
    @APIResponse(responseCode = "204", description = "Ville not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<VilleDto> villeDtos = new ArrayList<>();
        for (VilleEntity ville : villeRepository.listAll()){
            VilleDto villeDto = new VilleDto(ville);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            villeDto.addLinks("all", uriBase);
            villeDto.addLinks("self", uriBase +"/"+ ville.getIdVille());
            villeDtos.add(villeDto);
        }
        return Response.ok(villeDtos).build();
    }

    @GET
    @Path("{idVille}")
    public Response getById(@PathParam("idVille") Integer idVille){
        VilleDto ville = villeDtoById(villeRepository.findById(idVille));
        return Response.ok(ville).build();
    }

}
