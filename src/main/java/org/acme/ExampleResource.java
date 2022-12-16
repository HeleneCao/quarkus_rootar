package org.acme;

import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @Inject
    JsonWebToken jwt;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("secured")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("Admin")
    public String secureHello(){
        return "Hello Secured RESTEASY";
    }
}