package org.acme.endpoints;

import org.acme.dto.PrioriteDto;
import org.acme.entities.PrioriteEntity;
import org.acme.repositories.PrioriteRepository;
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
import static org.acme.dto.PrioriteDto.prioriteDtoById;

@Path("/priorite")
@Tag(name="Priorite")
@Produces(MediaType.APPLICATION_JSON)
public class PrioriteResource {
    @Inject
    PrioriteRepository prioriteRepository;


    @GET
    @Operation(summary = "Langues", description = "get all priorite")
    @APIResponse(responseCode = "200", description = "Ok, priorite found")
    @APIResponse(responseCode = "204", description = "Priorite not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<PrioriteDto> prioritesDto = new ArrayList<>();
        for (PrioriteEntity priorite: prioriteRepository.listAll()){
            PrioriteDto prioriteDto = new PrioriteDto(priorite);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            prioriteDto.addLinks("all", uriBase);
            prioriteDto.addLinks("self", uriBase +"/"+ priorite.getIdPriorite());
            prioritesDto.add(prioriteDto);


        }
        return Response.ok(prioritesDto).build();
    }

    @GET
    @Path("{idPriorite}")
    public Response getById(@PathParam("idPriorite") Integer idPriorite){
        PrioriteDto priorite = prioriteDtoById(prioriteRepository.findById(idPriorite));
        return Response.ok(priorite).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response insert(PrioriteEntity priorite) {

        if (priorite == null)
            return Response.status(Response.Status.BAD_REQUEST).build();
        prioriteRepository.persist(priorite);
        return Response.ok(priorite).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("{idPriorite}")
    public Response update(@PathParam("idPriorite") Integer idPriorite, PrioriteEntity priorite){
        PrioriteEntity prioriteEntity = prioriteRepository.findById(idPriorite);
        prioriteEntity.setLibellePriorite(priorite.getLibellePriorite());
        return Response.ok(priorite).build();
    }

    @DELETE
    @Path("/{idPriorite}")
    @Transactional
    public Response delete(@PathParam("idPriorite") Integer idPriorite) {
       prioriteRepository.deleteById(idPriorite);
        return Response.ok(idPriorite).build();
    }


}
