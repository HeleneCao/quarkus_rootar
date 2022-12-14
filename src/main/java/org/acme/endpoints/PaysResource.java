package org.acme.endpoints;

import org.acme.entities.ContinentEntity;
import org.acme.entities.PaysEntity;
import org.acme.repositories.PaysRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pays")
@Tag(name="Pays")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaysResource {

    @Inject
    PaysRepository paysRepository;
    @Context
    @GET
    public Response getAll(){
        List<PaysEntity> pays = paysRepository.listAll();
        return Response.ok(pays).build();
    }
    @GET
    @Path("{idPays}")
    public Response getById(@PathParam("idPays") Integer idPays){
        PaysEntity pays = paysRepository.findById(idPays);
        return Response.ok(pays).build();
    }
    @GET
    @Path("/count")
    @Transactional
    public long count() {
        return paysRepository.count();
    }
    @POST
    @Transactional
    public Response insert(PaysEntity pays) {

        if (pays == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        paysRepository.persist(pays);
        return Response.ok(pays).status(Response.Status.CREATED).build();
    }
    @PUT
    @Transactional
    @Path("{idPays}")
    public Response update(@PathParam("idPays") Integer idPays, PaysEntity pays){
        PaysEntity paysEntity = paysRepository.findById(idPays);
        paysEntity.setNomPaysFr(pays.getNomPaysFr());
        paysEntity.setNomPaysAng(pays.getNomPaysAng());
        return Response.ok(pays).build();
    }
    @DELETE
    @Path("/{idPays}")
    @Transactional
    public Response delete(@PathParam("idPays") Integer idPays) {

        paysRepository.deleteById(idPays);
        return Response.ok(idPays).build();

    }
}