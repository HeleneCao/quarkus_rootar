package org.acme.endpoints;

import org.acme.dto.RegionDto;
import org.acme.entities.RegionEntity;
import org.acme.repositories.RegionRepository;
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
import static org.acme.dto.RegionDto.regionDtoById;

@Path("/region")
@Tag(name="region")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegionResource {

    @Inject
    RegionRepository regionRepository;

    @GET
    @Operation(summary = "Region", description = "get all region")
    @APIResponse(responseCode = "200", description = "Ok, region found")
    @APIResponse(responseCode = "204", description = "Region not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<RegionDto> regionsDto = new ArrayList<>();
        for (RegionEntity region : regionRepository.listAll()){
            RegionDto regionDto = new RegionDto(region);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            regionDto.addLinks("all", uriBase);
            regionDto.addLinks("self", uriBase +"/"+ region.getIdRegion());
            regionsDto.add(regionDto);
        }
        return Response.ok(regionsDto).build();
    }

    @GET
    @Path("{idRegion}")
    public Response getById(@PathParam("idRegion") Integer idRegion){
        RegionDto region = regionDtoById(regionRepository.findById(idRegion));
        return Response.ok(region).build();
    }

    @POST
    @Transactional
    public Response insert(RegionEntity region){
        if (region == null)
            return  Response.status(Response.Status.BAD_REQUEST).build();

        regionRepository.persist(region);
        return Response.ok(region).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("{idRegion}")
    public Response update(@PathParam("idRegion") Integer idRegion, RegionEntity region){
        RegionEntity regionEntity = regionRepository.findById(idRegion);
        regionEntity.setNomRegion(region.getNomRegion());
        regionEntity.setPays(region.getPays());
        regionEntity.setTypeClimat(region.getTypeClimat());
        return Response.ok(region).build();
    }

    @DELETE
    @Path("/{idRegion}")
    public Response delete(@PathParam("idRegion") Integer idRegion){
        regionRepository.deleteById(idRegion);
        return  Response.ok(idRegion).build();
    }
}
