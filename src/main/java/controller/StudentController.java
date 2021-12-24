package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.Specialty;
import database.Subject;
import database.University;
import database.User;
import service.StudentService;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("std/")
public class StudentController {

    @EJB
    private StudentService service;

    private ObjectMapper om = new ObjectMapper();


    @GET
    @DenyAll
    @Produces("application/json")
    public String hello() {
        return "Hello!";
    }

    @GET
    @RolesAllowed({"STUDENT", "ADMIN"})
    @Path("all/")
    @Produces("application/json")
    public Response getAllStudents() {
        try {
            List<User> students = service.getAllStudents();
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
    @RolesAllowed({"STUDENT", "ADMIN"})
    @Path("specs/{id:[0-9]+}")
    @Produces("application/json")
    public Response specialtiesOfSubject(@PathParam("id") String id) throws JsonProcessingException {

        try {
            int subjId = Integer.parseInt(id);
            List<Specialty> specialties = service.getSpecialtiesOfSubject(subjId);
            String result = om.writeValueAsString(specialties);

            CacheControl cc = new CacheControl();
            cc.setMaxAge(20000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }

    }

    @GET
    @RolesAllowed({"STUDENT", "ADMIN"})
    @Path("unis/{id:[0-9]+}")
    @Produces("application/json")
    public Response universitiesOfSpecialty(@PathParam("id") String id) throws JsonProcessingException {
        try {
            int specId = Integer.parseInt(id);
            List<University> unis = service.getUniversitiesBySpecialtyId(specId);
            String result = om.writeValueAsString(unis);

            CacheControl cc = new CacheControl();
            cc.setMaxAge(20000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @GET
    @RolesAllowed({"STUDENT", "ADMIN"})
    @Path("uniSubjects/{id:[0-9]+}")
    @Produces("application/json")
    public Response universitySubjects(@PathParam("id") String sId) throws JsonProcessingException {
        try {
            int id = Integer.parseInt(sId);
            List<Subject> subjs = service.getUniversitySubjects(id);
            String result = om.writeValueAsString(subjs);

            CacheControl cc = new CacheControl();
            cc.setMaxAge(20000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @GET
    @RolesAllowed({"STUDENT", "ADMIN"})
    @Path("specSubjects/{id:[0-9]+}")
    @Produces("application/json")
    public Response specialtySubjects(@PathParam("id") String id) throws JsonProcessingException {
        try {
            int specId = Integer.parseInt(id);
            List<Subject> subjs = service.getSpecialtySubjects(specId);
            String result = om.writeValueAsString(subjs);

            CacheControl cc = new CacheControl();
            cc.setMaxAge(20000);
            cc.setPrivate(true);

            return Response.ok().entity(result).cacheControl(cc).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }


}
