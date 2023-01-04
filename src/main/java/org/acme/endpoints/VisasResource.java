package org.acme.endpoints;

import org.acme.dto.ContinentDto;
import org.acme.dto.VisasDto;
import org.acme.entities.ContinentEntity;
import org.acme.entities.VisasEntity;
import org.acme.repositories.VisasRepository;
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


}
