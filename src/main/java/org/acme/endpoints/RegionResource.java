package org.acme.endpoints;

import org.acme.dto.PaysDto;
import org.acme.dto.RegionDto;
import org.acme.entities.PaysEntity;
import org.acme.entities.RegionEntity;
import org.acme.repositories.RegionRepository;
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
}
