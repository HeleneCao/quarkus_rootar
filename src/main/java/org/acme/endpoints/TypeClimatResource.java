package org.acme.endpoints;

import org.acme.dto.TypeClimatDto;
import org.acme.entities.TypeClimatEntity;
import org.acme.repositories.TypeClimatRepository;
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
import static org.acme.dto.TypeClimatDto.typeClimatDtoById;

@Path("/type_climat")
@Tag(name="Type_climat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TypeClimatResource {

    @Inject
    TypeClimatRepository typeClimatRepository;
    @GET
    @Operation(summary = "Type climat", description = "get all type climat")
    @APIResponse(responseCode = "200", description = "Ok, type climatfound")
    @APIResponse(responseCode = "204", description = "type climat not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<TypeClimatDto> typeClimatsDto = new ArrayList<>();
        for (TypeClimatEntity typeClimat: typeClimatRepository.listAll()){
            TypeClimatDto typeClimatDto = new TypeClimatDto(typeClimat);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            typeClimatDto.addLinks("all", uriBase);
            typeClimatDto.addLinks("self", uriBase +"/"+ typeClimat.getIdTypeClimat());
            typeClimatsDto.add(typeClimatDto);


        }
        return Response.ok(typeClimatsDto).build();

    }
    @GET
    @Path("{idTypeClimat}")
    public Response getById(@PathParam("idTypeClimat") Integer idTypeClimat){
        TypeClimatDto typeClimat = typeClimatDtoById(typeClimatRepository.findById(idTypeClimat));
        return Response.ok(typeClimat).build();
    }

    @POST
    @Transactional
    public Response insert(TypeClimatEntity typeClimat) {
        if (typeClimat == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        typeClimatRepository.persist(typeClimat);
        return Response.ok(typeClimat).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("{idTypeClimat}")
    public Response update(@PathParam("idTypeClimat") Integer idTypeClimat, TypeClimatEntity typeClimat){
        TypeClimatEntity typeClimatEntity = typeClimatRepository.findById(idTypeClimat);
        typeClimatEntity.setLibelleTypeClimat(typeClimat.getLibelleTypeClimat());
        return Response.ok(typeClimat).build();
    }

    @DELETE
    @Path("/{idTypeClimat}")
    @Transactional
    public Response delete(@PathParam("idTypeClimat") Integer idTypeClimat) {
        typeClimatRepository.deleteById(idTypeClimat);
        return Response.ok(idTypeClimat).build();
    }

}
