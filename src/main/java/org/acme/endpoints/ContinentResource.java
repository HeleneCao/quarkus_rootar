package org.acme.endpoints;

import org.acme.entities.ContinentEntity;
import org.acme.repositories.ContinentRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/continent")
@Tag(name="Continent")
@Produces(MediaType.APPLICATION_JSON)
public class ContinentResource {
    @Inject
    ContinentRepository continentRepository;

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
    @POST
    @Transactional
    public Response create(ContinentEntity continent) {

        return Response.created(URI.create("/continent/" + continent.getNomContinentfr().build();
    }
}
