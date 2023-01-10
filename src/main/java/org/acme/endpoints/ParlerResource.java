package org.acme.endpoints;

import org.acme.dto.ParlerDto;
import org.acme.entities.DonneesClimatEntityPK;
import org.acme.entities.ParlerEntity;
import org.acme.entities.ParlerEntityPK;
import org.acme.repositories.ParlerRepository;
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
import static org.acme.dto.ParlerDto.parlerDtoById;

@Path("/parler")
@Tag(name="parler")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParlerResource {

    @Inject
    ParlerRepository parlerRepository;

    @GET
    @Operation(summary = "Parler", description = "get all type parler")
    @APIResponse(responseCode = "200", description = "Ok, type parler")
    @APIResponse(responseCode = "204", description = "type parler not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<ParlerDto> parlersDto = new ArrayList<>();
        for (ParlerEntity parler: parlerRepository.listAll()){
            ParlerDto parlerDto = new ParlerDto(parler);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            parlerDto.addLinks("all", uriBase);
            parlerDto.addLinks("self", uriBase +"/"+ parler.getIdLangues());
            parlersDto.add(parlerDto);
        }
        return Response.ok(parlersDto).build();
    }


    @GET
    @Path("{idPays}/{idLangues}")
    public Response getById(@PathParam("idPays") Integer idPays, @PathParam("idLangues") Integer idLangues){
        ParlerEntityPK parlerEntityPK = new ParlerEntityPK();
        parlerEntityPK.setIdPays(idPays);
        parlerEntityPK.setIdLangues(idLangues);
        return Response.ok(parlerDtoById(parlerRepository.findById(parlerEntityPK))).build();
    }
}
