package org.acme.endpoints;

import org.acme.dto.ContinentDto;
import org.acme.dto.MonnaieDto;
import org.acme.entities.ContinentEntity;
import org.acme.entities.MonnaieEntity;
import org.acme.repositories.MonnaieRepository;
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
import static org.acme.dto.MonnaieDto.monnaieDtoById;

@Path("/monnaie")
@Tag(name="Monnaie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MonnaieResource {

    @Inject
    MonnaieRepository monnaieRepository;

    @GET
    @Operation(summary = "Monnaie", description = "get all monnaie")
    @APIResponse(responseCode = "200", description = "Ok, monnaie found")
    @APIResponse(responseCode = "204", description = "Monnaie not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<MonnaieDto> monnaiesDto = new ArrayList<>();
        for (MonnaieEntity monnaie : monnaieRepository.listAll()){
            MonnaieDto monnaieDto = new MonnaieDto(monnaie);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            monnaieDto.addLinks("all", uriBase);
            monnaieDto.addLinks("self", uriBase +"/"+ monnaie.getIdMonnaie());
            monnaiesDto.add(monnaieDto);
        }
        return Response.ok(monnaiesDto).build();
    }

    @GET
    @Path("{idMonnaie}")
    public Response getById(@PathParam("idMonnaie") Integer idMonnaie){
        MonnaieDto monnaie = monnaieDtoById(monnaieRepository.findById(idMonnaie));
        return Response.ok(monnaie).build();
    }

    @POST
    @Transactional
    public Response insert(MonnaieEntity monnaie){
        if (monnaie == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        monnaieRepository.persist(monnaie);
        return Response.ok(monnaie).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("{idMonnaie}")
    public Response update(@PathParam("idMonnaie") Integer idMonnaie, MonnaieEntity monnaie){
        MonnaieEntity monnaieEntity = monnaieRepository.findById(idMonnaie);
        monnaieEntity.setIdMonnaie(monnaie.getIdMonnaie());
        monnaieEntity.setLibelleMonnaie(monnaie.getLibelleMonnaie());
        monnaieEntity.setPays(monnaie.getPays());
        return  Response.ok(monnaie).build();
    }

    @DELETE
    @Path("/{idMonnaie}")
    @Transactional
    public Response delete(@PathParam("idMonnaie") Integer idMonnaie){
        monnaieRepository.deleteById(idMonnaie);
        return Response.ok(idMonnaie).build();
    }


}
