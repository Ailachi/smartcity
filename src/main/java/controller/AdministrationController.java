package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import database.User;
import database.Vacancy;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import service.AdministrationService;
import service.JobService;
import view.UserView;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Path("admin/")
public class AdministrationController {

    @EJB
    private AdministrationService service;

    @EJB
    private JobService jobService;

    private ObjectMapper om = new ObjectMapper();

    @GET
    @RolesAllowed("ADMIN")
    @Path("considerVacancy/")
    public Response getVacancyForConsideration() {
        try {
            Vacancy vacancy = jobService.getVacancyJms();
            String result = om.writeValueAsString(vacancy);

            if(jobService.verifyVacancy(vacancy) == 0) {
                System.out.println("This vacancy cannot be added. Sorry");
            } else {
                int create = jobService.createVacancy(vacancy);

                if(create == 1) {
                    System.out.println("Vacancy is successfully created!");
                } else {
                    System.out.println("Vaccancy could not be created");
                }
            }

            CacheControl cc = new CacheControl();
            cc.setMaxAge(20000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @GET
    @Produces("application/json")
    @Path("users/")
    @RolesAllowed("ADMIN")
    public Response getAllUsers() {
        try {
            List<User> students = service.getAllUsers();
            String result = om.writeValueAsString(students);

            CacheControl cc = new CacheControl();
            cc.setMaxAge(20000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @GET
    @RolesAllowed("ADMIN")
    @Produces("application/json")
    @Path("users/{id:[0-9]}")
    public Response getUserById(@PathParam("id") String sID) {
        try {
            int id = Integer.parseInt(sID);
            UserView user = service.getUserById(id);
            String result = om.writeValueAsString(user);

            CacheControl cc = new CacheControl();
            cc.setMaxAge(20000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @POST
    @RolesAllowed("ADMIN")
    @Consumes("application/json")
    @Path("createUser/")
    public Response createUser(User user) {
        try {
            int result = service.createUser(user);
            return Response.ok().entity(result).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @PUT
    @RolesAllowed("ADMIN")
    @Path("updRole/")
    public Response updateUserRole(
            @FormParam("userID") int userID,
            @FormParam("roleID") int roleID
    ) {
        try {
            int result = service.updateRole(userID, roleID);
            return Response.ok().entity(result).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @DELETE
    @RolesAllowed("ADMIN")
    @Path("deleteUser/{id:[0-9]+}")
    public Response deleteUser(@PathParam("id") String sID) {
        try {
            int userID = Integer.parseInt(sID);
            int result = service.deleteUser(userID);
            return Response.ok().entity(result).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @POST
    @PermitAll
    @Path("authenticate/")
    public Response authenticate(@FormParam("email") String email,
                                 @FormParam("password") String password) {
        try {
            System.out.println("Checking user");
            User user = service.getUserByCredentials(email, password);

            if(user == null) {
                throw new InternalServerErrorException();
            }

            String token = issueToken(email, password);


            return Response.status(Response.Status.OK)
                    .header("AUTHORIZATION", "Bearer: " + token)
                    .build();

        } catch (Exception e) {
            System.out.println("Auth error!");
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    private String issueToken(String email, String password) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        String secret = "plefSFS89wfsklsdhSDSD32dfsddDDerQSNCK34SOWEK5354fdGdf4";

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());

        Instant now = Instant.now();
        String jwtToken = Jwts.builder()
                .claim("email", email)
                .claim("password", password)
                .setSubject("user")
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(5l, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();
        return jwtToken;
    }
}
