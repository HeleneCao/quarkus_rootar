package org.acme.endpoints;


import org.acme.dto.LanguesDto;
import org.acme.entities.LanguesEntity;
import org.acme.repositories.LanguesRepositoiry;
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

import static org.acme.dto.LanguesDto.languesDtoById;
import static org.acme.dto.VisasDto.visasDtoById;

@Path("/langues")
@Tag(name="langues")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LanguesResource {

    @Inject
    LanguesRepositoiry languesRepositoiry;

    @GET
    @Operation(summary = "Langues", description = "get all langues")
    @APIResponse(responseCode = "200", description = "Ok, langues found")
    @APIResponse(responseCode = "204", description = "Langues not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<LanguesDto> languessDto = new ArrayList<>();
        for (LanguesEntity langues : languesRepositoiry.listAll()){
            LanguesDto languesDto = new LanguesDto(langues);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            languesDto.addLinks("all", uriBase);
            languesDto.addLinks("self", uriBase +"/"+ langues.getIdLangues());
            languessDto.add(languesDto);
        }
        return Response.ok(languessDto).build();
    }

    @GET
    @Path("{idLangues}")
    public Response getById(@PathParam("idLangues") Integer idLangues){
        LanguesDto langues = languesDtoById(languesRepositoiry.findById(idLangues));
        return Response.ok(langues).build();
    }
}
