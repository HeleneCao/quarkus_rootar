package org.acme.endpoints;

import org.acme.dto.ContinentDto;
import org.acme.entities.ContinentEntity;
import org.acme.repositories.ContinentRepository;
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

import static org.acme.dto.ContinentDto.continentDtoById;

@Path("/continent")
@Tag(name="Continent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContinentResource {
    @Inject
    ContinentRepository continentRepository;

    @GET
    @Operation(summary = "Continent", description = "get all continent")
    @APIResponse(responseCode = "200", description = "Ok, continent found")
    @APIResponse(responseCode = "204", description = "Continent not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<ContinentDto> continentsDto = new ArrayList<>();
        for (ContinentEntity continent : continentRepository.listAll()){
            ContinentDto continentDto = new ContinentDto(continent);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            continentDto.addLinks("all", uriBase);
            continentDto.addLinks("self", uriBase +"/"+ continent.getIdContinent());
            continentsDto.add(continentDto);
        }
        return Response.ok(continentsDto).build();
    }

    @GET
    @Path("{idContinent}")
    public Response getById(@PathParam("idContinent") Integer idContinent){
        ContinentDto continent = continentDtoById(continentRepository.findById(idContinent));
        return Response.ok(continent).build();
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

    @GET
    @Path("/count")
    @Transactional
    public long count() {
        return continentRepository.count();
    }

}
