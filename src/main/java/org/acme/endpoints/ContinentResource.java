package org.acme.endpoints;

import org.acme.entities.ContinentEntity;
import org.acme.repositories.ContinentRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/continent")
@Tag(name="Continent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContinentResource {
    @Inject
    ContinentRepository continentRepository;
@Context
    UriInfo uriInfo;
    @GET
    public Response getAll(){
        List<ContinentEntity> continents = continentRepository.listAll();
        return Response.ok(continents).build();
    }
    @GET
    @Path("{idContinent}")
    public Response getById(@PathParam("idContinent") Integer idContinent){
        ContinentEntity continent = continentRepository.findById(idContinent);
        return Response.ok(continent).build();
    }
    @GET
    @Path("/count")
    @Transactional
    public long count() {
        return continentRepository.count();
    }
    @POST
    @Transactional
    public Response insert(ContinentEntity continent) {

        if (continent == null)
            return Response.status(Response.Status.BAD_REQUEST).build();


        continentRepository.persist(continent);
        return Response.ok(continent).status(Response.Status.CREATED).build();
    }
    @PUT
    @Transactional
    @Path("{idContinent}")
    public Response update(@PathParam("idContinent") Integer idContinent, ContinentEntity continent){
        ContinentEntity continentEntity = continentRepository.findById(idContinent);
       continentEntity.setNomContinentFr(continent.getNomContinentFr());
        continentEntity.setNomContinentAng(continent.getNomContinentAng());



        return Response.ok(continent).build();
    }
    @DELETE
    @Path("/{idContinent}")
    @Transactional
    public Response delete(@PathParam("idContinent") Integer idContinent) {

        continentRepository.deleteById(idContinent);
        return Response.ok(idContinent).build();


    }



}
