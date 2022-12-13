package org.acme.endpoints;

import org.acme.entities.ContinentEntity;
import org.acme.repositories.ContinentRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
}
