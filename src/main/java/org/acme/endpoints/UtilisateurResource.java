package org.acme.endpoints;

import org.acme.dto.UtilisateurDto;
import org.acme.entities.UtilisateurEntity;
import org.acme.repositories.UtilisateurRepository;
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
import static org.acme.dto.UtilisateurDto.utilisateurDtoById;


@Path("/Utilisateur")
@Tag(name="utilisateur")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UtilisateurResource {

    @Inject
    UtilisateurRepository utilisateurRepository;

    @GET
    @Operation(summary = "User", description = "get all users")
    @APIResponse(responseCode = "200", description = "Ok, user found")
    @APIResponse(responseCode = "204", description = "User not found")
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

    @POST
    @Transactional
    public Response insert(UtilisateurEntity utilisateur) {
        if (utilisateur == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        utilisateurRepository.persist(utilisateur);
        return Response.ok(utilisateur).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("{login}")
    public Response update(@PathParam("login") String login, UtilisateurEntity utilisateur){
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findById(login);
        utilisateurEntity.setLogin(utilisateur.getLogin());
        utilisateurEntity.setMail(utilisateur.getMail());
        utilisateurEntity.setNom(utilisateur.getNom());
        utilisateurEntity.setPassword(utilisateur.getPassword());
        utilisateurEntity.setPrenom(utilisateur.getPrenom());
        utilisateurEntity.setRole(utilisateur.getRole());
        return Response.ok(utilisateur).build();
    }

    @DELETE
    @Path("/{login}")
    @Transactional
    public Response delete(@PathParam("login") String login) {
        utilisateurRepository.deleteById(login);
        return Response.ok(login).build();
    }

}


