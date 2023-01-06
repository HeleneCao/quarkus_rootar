package org.acme.endpoints;

import org.acme.dto.CategoriesDto;
import org.acme.dto.LanguesDto;
import org.acme.dto.ObjetDto;
import org.acme.entities.LanguesEntity;
import org.acme.entities.ObjetEntity;
import org.acme.repositories.ObjetRepository;
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

import static org.acme.dto.CategoriesDto.categoriesDtoById;
import static org.acme.dto.ObjetDto.objetDtoById;

@Path("/objet")
@Tag(name="Objets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ObjetResource {
    @Inject
    ObjetRepository objetRepository;
    @GET
    @Operation(summary = "Objets", description = "get all objets")
    @APIResponse(responseCode = "200", description = "Ok, objets found")
    @APIResponse(responseCode = "204", description = "Objets not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<ObjetDto> objetsDto = new ArrayList<>();
        for (ObjetEntity objet : objetRepository.listAll()){
            ObjetDto objetDto = new ObjetDto(objet);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            objetDto.addLinks("all", uriBase);
            objetDto.addLinks("self", uriBase +"/"+ objet.getIdObjet());
            objetsDto.add(objetDto);
        }
        return Response.ok(objetsDto).build();
    }
    @GET
    @Path("{idObjets}")
    public Response getById(@PathParam("idObjets") Integer idObjets){
        ObjetDto objet= objetDtoById(objetRepository.findById(idObjets));
        return Response.ok(objet).build();
    }


}
