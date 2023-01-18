package org.acme.endpoints;

import org.acme.dto.CategoriesDto;
import org.acme.entities.CategoriesEntity;
import org.acme.repositories.CategoriesRepository;
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

import static org.acme.dto.CategoriesDto.categoriesDtoById;

@Path("/categories")
@Tag(name="Categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriesResource {
    @Inject
    CategoriesRepository categoriesRepository;
    @GET
    @Operation(summary = "Categories", description = "get all categories")
    @APIResponse(responseCode = "200", description = "Ok, categories found")
    @APIResponse(responseCode = "204", description = "Categories not found")
    public Response getAll(@Context UriInfo uriInfo){
        List<CategoriesDto> categoriesDtos = new ArrayList<>();
        for (CategoriesEntity categories : categoriesRepository.listAll()){
            CategoriesDto categoriesDto = new CategoriesDto(categories);
            String uriBase = uriInfo.getRequestUriBuilder().build().toString();
            categoriesDto.addLinks("all", uriBase);
            categoriesDto.addLinks("self", uriBase +"/"+ categories.getIdCategories());
            categoriesDtos.add(categoriesDto);
        }
        return Response.ok(categoriesDtos).build();

    }
    @GET
    @Path("{idCategories}")
    public Response getById(@PathParam("idCategories") Integer idCat){
        CategoriesDto categories = categoriesDtoById(categoriesRepository.findById(idCat));
        return Response.ok(categories).build();
    }

    @POST
    @Transactional
    public Response insert(CategoriesEntity categories){
        if (categories == null)
            return  Response.status(Response.Status.BAD_REQUEST).build();

        categoriesRepository.persist(categories);
        return Response.ok(categories).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("{idCategorie}")
    public Response update(@PathParam("idCategorie") Integer idCategorie, CategoriesEntity categories){
        CategoriesEntity categoriesEntity = categoriesRepository.findById(idCategorie);
        categoriesEntity.setLibelleCategories(categories.getLibelleCategories());
        return Response.ok(categories).build();
    }

    @DELETE
    @Path("/{idCategorie}")
    @Transactional
    public Response delete (@PathParam("idCategorie") Integer idCategorie){
        categoriesRepository.deleteById(idCategorie);
        return Response.ok(idCategorie).build();
    }
}
