package org.acme.endpoints;

import org.acme.dto.UtilisateurDto;
import org.acme.dto.VilleDto;
import org.acme.entities.UtilisateurEntity;
import org.acme.entities.VilleEntity;
import org.acme.repositories.UtilisateurRepository;
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

import static org.acme.dto.UtilisateurDto.utilisateurDtoById;
import static org.acme.dto.VilleDto.villeDtoById;

@Path("/Utilisateur")
@Tag(name="utilisateur")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UtilisateurResource {

    @Inject
    UtilisateurRepository utilisateurRepository;

    @GET
    @Operation(summary = "Utilisateur", description = "get all utilisateur")
    @APIResponse(responseCode = "200", description = "Ok, utilisateur found")
    @APIResponse(responseCode = "204", description = "Utilisateur not found")
    public Response getAll(@Context UriInfo uriInfo) {
        List<UtilisateurDto> utilisateurDtos = new ArrayList<>();
        for (UtilisateurEntity utilisateur : utilisateurRepository.listAll()) {
            UtilisateurDto utilisateurDto = new UtilisateurDto(utilisateur);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            utilisateurDto.addLinks("all", uriBase);

            utilisateurDtos.add(utilisateurDto);
        }
        return Response.ok(utilisateurDtos).build();
    }

    @GET
    @Path("{login}")
    public Response getById(@PathParam("login") String login) {
        UtilisateurDto utilisateur = utilisateurDtoById(utilisateurRepository.findById(login));
        return Response.ok(utilisateur).build();
    }

}


