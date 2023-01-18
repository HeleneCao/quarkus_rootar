package org.acme.endpoints;

import org.acme.dto.VisasDto;
import org.acme.entities.VisasEntity;
import org.acme.repositories.VisasRepository;
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
import static org.acme.dto.VisasDto.visasDtoById;

@Path("/visas")
@Tag(name="Visas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VisasResource {

    @Inject
    VisasRepository visasRepository;

    @GET
    @Operation(summary = "Visas", description = "get all visas")
    @APIResponse(responseCode = "200", description = "Ok, visas found")
    @APIResponse(responseCode = "204", description = "Visas not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<VisasDto> visassDto = new ArrayList<>();
        for (VisasEntity visas : visasRepository.listAll()){
            VisasDto visasDto = new VisasDto(visas);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            visasDto.addLinks("all", uriBase);
            visasDto.addLinks("self", uriBase +"/"+ visas.getIdVisas());
            visassDto.add(visasDto);
        }
        return Response.ok(visassDto).build();
    }

    @GET
    @Path("{idVisas}")
    public Response getById(@PathParam("idVisas") Integer idVisas){
        VisasDto visas = visasDtoById(visasRepository.findById(idVisas));
        return Response.ok(visas).build();
    }

    @POST
    @Transactional
    public Response insert(VisasEntity visas) {
        if (visas == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        visasRepository.persist(visas);
        return Response.ok(visas).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("{idVisas}")
    public Response update(@PathParam("idVisas") Integer idVisas, VisasEntity visas){
        VisasEntity visasEntity = visasRepository.findById(idVisas);
        visasEntity.setDureeValidite(visas.getDureeValidite());
        visasEntity.setDelaiObtention(visas.getDelaiObtention());
        visasEntity.setPrixVisas(visas.getPrixVisas());
        visasEntity.setTypeVisa(visas.getTypeVisa());
        return Response.ok(visas).build();
    }

    @DELETE
    @Path("/{idVisas}")
    @Transactional
    public Response delete(@PathParam("idVisas") Integer idVisas) {
        visasRepository.deleteById(idVisas);
        return Response.ok(idVisas).build();
    }
}
