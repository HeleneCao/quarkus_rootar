package org.acme.endpoints;

import org.acme.dto.LanguesDto;
import org.acme.dto.TypeVisasDto;
import org.acme.entities.LanguesEntity;
import org.acme.entities.TypeVisaEntity;
import org.acme.repositories.TypeVisasRepository;
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
import static org.acme.dto.TypeVisasDto.typeVisasDtoById;

@Path("/typeVisas")
@Tag(name="typeVisas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TypeVisasResource {

    @Inject
    TypeVisasRepository typeVisasRepository;

    @GET
    @Operation(summary = "TypeVisas", description = "get all type visas")
    @APIResponse(responseCode = "200", description = "Ok, type visas found")
    @APIResponse(responseCode = "204", description = "type visas not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<TypeVisasDto> typeVisasDtos = new ArrayList<>();
        for (TypeVisaEntity typeVisas : typeVisasRepository.listAll()){
            TypeVisasDto typeVisasDto = new TypeVisasDto(typeVisas);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            typeVisasDto.addLinks("all", uriBase);
            typeVisasDto.addLinks("self", uriBase +"/"+ typeVisas.getIdTypeVisa());
            typeVisasDtos.add(typeVisasDto);


        }
        return Response.ok(typeVisasDtos).build();

    }

    @GET
    @Path("{idTypeVisas}")
    public Response getById(@PathParam("idTypeVisas") Integer idTypeVisas){
        TypeVisasDto typeVisas = typeVisasDtoById(typeVisasRepository.findById(idTypeVisas));
        return Response.ok(typeVisas).build();
    }
}
