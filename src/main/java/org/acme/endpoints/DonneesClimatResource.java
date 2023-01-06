package org.acme.endpoints;

import org.acme.dto.ContinentDto;
import org.acme.dto.DonneesClimatDto;
import org.acme.dto.RepresentationEtrangereDto;
import org.acme.entities.ContinentEntity;
import org.acme.entities.DonneesClimatEntity;
import org.acme.entities.DonneesClimatEntityPK;
import org.acme.repositories.DonneesClimatRepository;
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

import static org.acme.dto.DonneesClimatDto.dcDtoById;
import static org.acme.dto.EvenementDto.evenementDtoById;

@Path("/donneesClimat")
@Tag(name="DonneesClimat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DonneesClimatResource {
    @Inject
    DonneesClimatRepository donneesClimatRepository;

    @GET
    @Operation(summary = "DonneesClimat", description = "get all DonneesClimat")
    @APIResponse(responseCode = "200", description = "Ok, DonneesClimat found")
    @APIResponse(responseCode = "204", description = "DonneesClimat not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<DonneesClimatDto> donneesClimatsDto = new ArrayList<>();
        for (DonneesClimatEntity donneesClimat: donneesClimatRepository.listAll()){
            DonneesClimatDto donneesClimatDto = new DonneesClimatDto(donneesClimat);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            donneesClimatDto.addLinks("all", uriBase);
            donneesClimatDto.addLinks("self", uriBase +"/"+ donneesClimat.getIdRegion() );
            donneesClimatsDto.add(donneesClimatDto);
        }
        return Response.ok(donneesClimatsDto).build();

    }
    @GET
    @Path("{idDC}/{mois}")
    public Response getById(@PathParam("idDC") Integer idDC,@PathParam("mois") Integer mois){
        DonneesClimatEntityPK donneesClimatEntityPK = new DonneesClimatEntityPK();
        donneesClimatEntityPK.setIdRegion(idDC);
        donneesClimatEntityPK.setMois(mois);
        return Response.ok(dcDtoById(donneesClimatRepository.findById(donneesClimatEntityPK))).build();
    }
}
