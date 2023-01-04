package org.acme.security;



import io.quarkus.arc.Priority;

import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import javax.ws.rs.core.Response;

@Provider
@Tokened
@Priority(Priorities.AUTHENTICATION)
public class TokenedFilter implements ContainerRequestFilter {


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
         // Récupère la clef Token dans le header
        String tokenHeader = requestContext.getHeaderString(Tokened.TOKEN);
        MyToken token = new MyToken(tokenHeader);

        if (!token.isValide())
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
    }
}