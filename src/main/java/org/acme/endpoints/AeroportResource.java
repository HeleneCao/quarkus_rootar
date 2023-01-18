package org.acme.endpoints;

import org.acme.dto.AeroportDto;
import org.acme.entities.AeroportEntity;
import org.acme.repositories.AeroportRepository;
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

    @POST
    @Transactional
    public Response insert(AeroportEntity aeroport){
        if (aeroport == null)
            return  Response.status(Response.Status.BAD_REQUEST).build();

        aeroportRepository.persist(aeroport);
        return Response.ok(aeroport).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("{idAeroport}")
    public Response update(@PathParam("idAeroport") Integer idAeroport, AeroportEntity aeroport){
        AeroportEntity aeroportEntity = aeroportRepository.findById(idAeroport);
        aeroportEntity.setLibelleAeroport(aeroport.getLibelleAeroport());
        aeroportEntity.setAdresse(aeroport.getAdresse());
        aeroportEntity.setTelephone(aeroport.getTelephone());
        aeroportEntity.setVille(aeroport.getVille());
        return Response.ok(aeroport).build();
    }

    @DELETE
    @Path("/{idAeroport}")
    @Transactional
    public Response delete(@PathParam("idAeroport") Integer idAeroport){
        aeroportRepository.deleteById(idAeroport);
        return Response.ok(idAeroport).build();
    }
}
