package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.TouristService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

@Path("tourist/")
public class TouristController {
    @EJB
    private TouristService service;

    private ObjectMapper om = new ObjectMapper();

    @GET
    @RolesAllowed({"TOURIST", "ADMIN"})
    @Path("sights/")
    public Response getAllSights() {
        try {
            String result = om.writeValueAsString(service.getAllSights());

            return Response.ok().entity(result).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @GET
    @RolesAllowed({"TOURIST", "ADMIN"})
    @Path("sights/{id:[0-9]}")
    public Response getSightById(@PathParam("id") String sId) {
        try {
            int id = Integer.parseInt(sId);
            String result = om.writeValueAsString(service.getSightById(id));

            CacheControl cc = new CacheControl();
            cc.setMaxAge(4000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @GET
    @RolesAllowed({"TOURIST", "ADMIN"})
    @Path("sightPlace/{id:[0-9]+}")
    public Response getPlaceBySightId(@PathParam("id") String sId) {
        try {
            int id = Integer.parseInt(sId);
            String result = om.writeValueAsString(service.getPlaceBySightId(id));

            CacheControl cc = new CacheControl();
            cc.setMaxAge(4000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @GET
    @RolesAllowed({"TOURIST", "ADMIN"})
    @Path("sightsByPlace/{id:[0-9]+}")
    public Response getSightsByPlaceId(@PathParam("id") String sId) {
        try {
            int id = Integer.parseInt(sId);
            String result = om.writeValueAsString(service.getSightsByPlaceId(id));

            CacheControl cc = new CacheControl();
            cc.setMaxAge(4000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }



}
