package org.acme.endpoints;


import org.acme.dto.SanteDto;
import org.acme.dto.ThemesDto;
import org.acme.entities.SanteEntity;
import org.acme.entities.ThemesEntity;
import org.acme.repositories.ThemesRepository;
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

import static org.acme.dto.SanteDto.santeDtoById;
import static org.acme.dto.ThemesDto.themesDtoById;

@Path("/themes")
@Tag(name="Themes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ThemesResource {
    @Inject
    ThemesRepository themesRepository;
    @GET
    @Operation(summary = "thèmes", description = "get all thème")
    @APIResponse(responseCode = "200", description = "Ok, thèmes found")
    @APIResponse(responseCode = "204", description = "thèmes not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<ThemesDto> themesDtos = new ArrayList<>();
        for (ThemesEntity themes: themesRepository.listAll()){
            ThemesDto themesDto = new ThemesDto(themes);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            themesDto.addLinks("all", uriBase);
            themesDto.addLinks("self", uriBase +"/"+ themes.getIdTheme());
            themesDtos.add(themesDto);
        }
        return Response.ok(themesDtos).build();
    }
    @GET
    @Path("{idThemes}")
    public Response getById(@PathParam("idThemes") Integer idThemes){
        ThemesDto themes= themesDtoById(themesRepository.findById(idThemes));
        return Response.ok(themes).build();
    }
}
