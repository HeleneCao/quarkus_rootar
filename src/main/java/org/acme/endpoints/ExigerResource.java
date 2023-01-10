package org.acme.endpoints;

import org.acme.dto.ExigerDto;
import org.acme.entities.DonneesClimatEntityPK;
import org.acme.entities.ExigerEntity;
import org.acme.entities.ExigerEntityPK;
import org.acme.repositories.ExigerRepository;
import org.acme.repositories.PaysRepository;
import org.acme.repositories.SanteRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.acme.dto.DonneesClimatDto.dcDtoById;
import static org.acme.dto.ExigerDto.exigerDtoById;

@Path("/exiger")
@Tag(name="Exiger")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExigerResource {

    @Inject
    ExigerRepository exigerRepository;
    @Inject
    PaysRepository paysRepository;
    @Inject
    SanteRepository santeRepository;
    @GET
    @Path("{idPays}/{idSante}")
    public Response getById(@PathParam("idPays") Integer idPays, @PathParam("idSante") Integer idSante){
        ExigerEntityPK exigerEntityPK = new ExigerEntityPK();
        exigerEntityPK.setIdPays(idPays);
        exigerEntityPK.setIdSante(idSante);
        System.out.println(idPays);
        return Response.ok(exigerDtoById(exigerRepository.findById(exigerEntityPK))).build();
    }
}
