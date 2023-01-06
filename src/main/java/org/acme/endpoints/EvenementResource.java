package org.acme.endpoints;

import org.acme.dto.ContinentDto;
import org.acme.dto.EvenementDto;
import org.acme.entities.ContinentEntity;
import org.acme.entities.EvenementsEntity;
import org.acme.repositories.EvenementRepository;
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

import static org.acme.dto.ContinentDto.continentDtoById;
import static org.acme.dto.EvenementDto.evenementDtoById;

@Path("/evenement")
@Tag(name="Evevement")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvenementResource {

    @Inject
    EvenementRepository evenementRepository;

    @GET
    @Operation(summary = "Evénements", description = "get all evénement")
    @APIResponse(responseCode = "200", description = "Ok, evénement found")
    @APIResponse(responseCode = "204", description = "evénement not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<EvenementDto> evenementsDtos = new ArrayList<>();
        for (EvenementsEntity evenement: evenementRepository.listAll()){
            EvenementDto evenementDto = new EvenementDto(evenement);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            evenementDto.addLinks("all", uriBase);
            evenementDto.addLinks("self", uriBase +"/"+ evenement.getIdEvenements());
            evenementsDtos.add(evenementDto);


        }
        return Response.ok(evenementsDtos).build();

    }

    @GET
    @Path("{idEvenement}")
    public Response getById(@PathParam("idEvenement") Integer idEvenement){
        return Response.ok( evenementDtoById(evenementRepository.findById(idEvenement))).build();
    }
}
