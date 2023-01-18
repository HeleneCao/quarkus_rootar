package org.acme.endpoints;

import org.acme.dto.SanteDto;
import org.acme.entities.SanteEntity;
import org.acme.repositories.SanteRepository;
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
import static org.acme.dto.SanteDto.santeDtoById;

@Path("/Sante")
@Tag(name="Santes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SanteResource {

    @Inject
    SanteRepository santeRepository;
    @GET
    @Operation(summary = "Santes", description = "get all Sante")
    @APIResponse(responseCode = "200", description = "Ok, Santes found")
    @APIResponse(responseCode = "204", description = "Santes not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<SanteDto> santesDto = new ArrayList<>();
        for (SanteEntity sante : santeRepository.listAll()){
            SanteDto santeDto = new SanteDto(sante);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            santeDto.addLinks("all", uriBase);
            santeDto.addLinks("self", uriBase +"/"+ sante.getIdSante());
            santesDto.add(santeDto);
        }
        return Response.ok(santesDto).build();
    }
    @GET
    @Path("{idSante}")
    public Response getById(@PathParam("idSante") Integer idSante){
        SanteDto sante= santeDtoById(santeRepository.findById(idSante));
        return Response.ok(sante).build();
    }

    @POST
    @Transactional
    public Response insert(SanteEntity sante){
        if (sante == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        santeRepository.persist(sante);
        return Response.ok(sante).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("/{idSante}")
    public Response update(@PathParam("idSante") Integer idSante, SanteEntity sante){
        SanteEntity santeEntity = santeRepository.findById(idSante);
        santeEntity.setLibelleSante(sante.getLibelleSante());
        santeEntity.setPriorite(sante.getPriorite());
        return Response.ok(sante).build();
    }

    @DELETE
    @Path("/{idSante}")
    @Transactional
    public Response delete(@PathParam("idSante") Integer idSante) {
        santeRepository.deleteById(idSante);
        return Response.ok(idSante).build();
    }
}
