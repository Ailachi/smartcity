package filter;


import database.Role;
import database.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import service.AdministrationService;

import javax.annotation.Priority;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;


@Provider
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenFilter implements ContainerRequestFilter {

    public JWTTokenFilter() throws NoSuchAlgorithmException {
    }

    private static final String AUTHORIZATION_PROPERTY = "Authorization";

    @Context
    private ResourceInfo resourceInfo;

    @EJB
    private AdministrationService service;


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Method method = resourceInfo.getResourceMethod();

        System.out.println("inside filter");
        if(!method.isAnnotationPresent(PermitAll.class)) {
            System.out.println("Not for all");
            if(method.isAnnotationPresent(DenyAll.class)) {
                requestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
                        .entity("Access blocked for all users !!").build());
            }
            //Get request headers
            final MultivaluedMap<String, String> headers = requestContext.getHeaders();

            //Fetch authorization header
            final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);


            //If no authorization information present; block access
            if (!Optional.ofNullable(authorization).isPresent() || authorization.isEmpty()) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                        .entity("You cannot access this resource").build());
                return;
            }

            String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
            try {
                String token = authorizationHeader.substring("Bearer".length()).trim();
                String secret = "plefSFS89wfsklsdhSDSD32dfsddDDerQSNCK34SOWEK5354fdGdf4";
                Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                        SignatureAlgorithm.HS256.getJcaName());

                Jws<Claims> claims = Jwts.parserBuilder()
                        .setSigningKey(hmacKey)
                        .build()
                        .parseClaimsJws(token);

                System.out.println("VALIDATED: " + token);

                String email = (String) claims.getBody().get("email");
                String password = (String) claims.getBody().get("password");
                System.out.println("Credentials: ");
                System.out.println("Email: " + email + ", Password: " + password);

                List<String> roles = new ArrayList<>();

                if(method.isAnnotationPresent(RolesAllowed.class)) {
                    System.out.println("Roles allowed present");
                    RolesAllowed allowed = method.getAnnotation(RolesAllowed.class);
                    roles = Arrays.asList(allowed.value());
                } else {
                    roles.add("TOURIST");
                }
                User user = service.getUserByCredentials(email, password);
                System.out.println("Allowrd roles: ");
                System.out.println(roles);
                System.out.println("User: ");
                System.out.println(user);

                if(user == null || !roles.contains(user.getRole().getName().toUpperCase())) {
                    // no access
                    System.out.println("No access");
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                }
                // access given, proceed with the method

            } catch (Exception e) {
                System.out.println("BUSTED, GET OUT OF HERE, SON: ");
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }

        } else {
            System.out.println("Permitted for All");
        }

    }
}
