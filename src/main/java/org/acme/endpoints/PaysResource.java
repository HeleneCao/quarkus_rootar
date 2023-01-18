package org.acme.endpoints;

import org.acme.dto.PaysDto;
import org.acme.entities.PaysEntity;
import org.acme.repositories.PaysRepository;
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
import static org.acme.dto.PaysDto.paysDtoById;

@Path("/pays")
@Tag(name="Pays")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaysResource {

    @Inject
    PaysRepository paysRepository;

    @GET
    @Operation(summary = "Pays", description = "get all pays")
    @APIResponse(responseCode = "200", description = "Ok, pays found")
    @APIResponse(responseCode = "204", description = "Pays not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<PaysDto> paysDtos = new ArrayList<>();
        for (PaysEntity pays : paysRepository.listAll()){
          PaysDto paysDto = new PaysDto(pays);
          String uriBase = uriInfo.getRequestUriBuilder().build().toString();
          paysDto.addLinks("all", uriBase);
          paysDto.addLinks("self", uriBase +"/"+ pays.getIdPays());
          paysDtos.add(paysDto);
        }
        return Response.ok(paysDtos).build();
    }

    @GET
    @Path("{idPays}")
    public Response getById(@PathParam("idPays") Integer idPays){
        PaysDto pays = paysDtoById(paysRepository.findById(idPays));
        return Response.ok(pays).build();
    }

    @POST
    @Transactional
    public Response insert(PaysEntity pays) {

        if (pays == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        paysRepository.persist(pays);
        return Response.ok(pays).status(Response.Status.CREATED).build();
    }
    @PUT
    @Transactional
    @Path("{idPays}")
    public Response update(@PathParam("idPays") Integer idPays, PaysEntity pays){
        PaysEntity paysEntity = paysRepository.findById(idPays);
        paysEntity.setNomPaysFr(pays.getNomPaysFr());
        paysEntity.setNomPaysAng(pays.getNomPaysAng());
        return Response.ok(pays).build();
    }
    @DELETE
    @Path("/{idPays}")
    @Transactional
    public Response delete(@PathParam("idPays") Integer idPays) {

        paysRepository.deleteById(idPays);
        return Response.ok(idPays).build();
    }

    @GET
    @Path("/count")
    @Transactional
    public long count() {
        return paysRepository.count();
    }
}
