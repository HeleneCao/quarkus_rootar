package org.acme.endpoints;

import org.acme.dto.AeroportDto;
import org.acme.dto.CategoriesDto;
import org.acme.entities.AeroportEntity;
import org.acme.entities.CategoriesEntity;
import org.acme.repositories.AeroportRepository;
import org.acme.repositories.CategoriesRepository;
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

import static org.acme.dto.AeroportDto.aeroportDtoById;


@Path("/aeroport")
@Tag(name="Aeroports")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AeroportResource {

    @Inject
    AeroportRepository aeroportRepository;
    @GET
    @Operation(summary = "Aeroports", description = "get al lAeroports")
    @APIResponse(responseCode = "200", description = "Ok, Aeroport found")
    @APIResponse(responseCode = "204", description = "Aeroport not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<AeroportDto> aeroportsDto = new ArrayList<>();
        for (AeroportEntity aeroport : aeroportRepository.listAll()){
            AeroportDto aeroportDto = new AeroportDto(aeroport);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            aeroportDto.addLinks("all", uriBase);
            aeroportDto.addLinks("self", uriBase +"/"+ aeroport.getIdAeroport());
            aeroportsDto.add(aeroportDto);
        }
        return Response.ok(aeroportsDto).build();

    }
    @GET
    @Path("{idAeroport}")
    public Response getById(@PathParam("idAeroport") Integer idAeroport){
       AeroportDto aeroport = aeroportDtoById(aeroportRepository.findById(idAeroport));
        return Response.ok(aeroport).build();
    }


}
