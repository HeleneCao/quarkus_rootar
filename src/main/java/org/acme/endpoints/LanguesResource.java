package org.acme.endpoints;

import org.acme.dto.ContinentDto;
import org.acme.dto.LanguesDto;
import org.acme.entities.ContinentEntity;
import org.acme.entities.LanguesEntity;
import org.acme.repositories.LanguesRepositoiry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

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

}
