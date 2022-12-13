package org.acme.endpoints;

import org.acme.entities.ContinentEntity;
import org.acme.entities.PrioriteEntity;
import org.acme.repositories.ContinentRepository;
import org.acme.repositories.PrioriteRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/priorite")
@Tag(name="Priorite")
@Produces(MediaType.APPLICATION_JSON)
public class PrioriteResource {
    @Inject
    PrioriteRepository prioriteRepository;

    @GET
    public Response getAll(){
        List<PrioriteEntity> priorites = prioriteRepository.listAll();
        return Response.ok(priorites).build();
    }
    @GET
    @Path("{idPriorite}")
    public Response getById(@PathParam("idPriorite") Integer idPriorite){
        PrioriteEntity priorite = prioriteRepository.findById(idPriorite);
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
