package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.BusinessService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

@Path("business/")
public class BusinessController {
    @EJB
    private BusinessService service;
    private ObjectMapper om = new ObjectMapper();

    @GET
    @RolesAllowed({"BUSINESSPERSON", "ADMIN"})
    @Produces("application/json")
    @Path("news/")
    public Response getBusinessNews() {
        try {
            String result = om.writeValueAsString(service.getBusinessNews());
            return Response.ok().entity(result).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @GET
    @RolesAllowed({"BUSINESSPERSON", "ADMIN"})
    @Path("authorOf/{id:[0-9]+}")
    @Produces("application/json")
    public Response getNewsAuthor(@PathParam("id") String bId) {
        try {
            int id = Integer.parseInt(bId);
            String result = om.writeValueAsString(service.getAuthorByNewsId(id));

            CacheControl cc = new CacheControl();
            cc.setMaxAge(3000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @GET
    @RolesAllowed({"BUSINESSPERSON", "ADMIN"})
    @Path("newsByAuthor/{id:[0-9]+}")
    @Produces("application/json")
    public Response getNewsOfAuthor(@PathParam("id") String uId) {
        try {
            int id = Integer.parseInt(uId);
            String result = om.writeValueAsString(service.getNewsByAuthorId(id));

            CacheControl cc = new CacheControl();
            cc.setMaxAge(3000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @GET
    @RolesAllowed({"BUSINESSPERSON", "ADMIN"})
    @Path("newsById/{id:[0-9]+}")
    @Produces("application/json")
    public Response getNewsById(@PathParam("id") String bId) {
        try {
            int id = Integer.parseInt(bId);
            String result = om.writeValueAsString(service.getNewsById(id));

            CacheControl cc = new CacheControl();
            cc.setMaxAge(3000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }
}
