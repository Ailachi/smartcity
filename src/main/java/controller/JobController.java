package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import database.Vacancy;
import service.JobService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("job/")
public class JobController {

    @EJB
    private JobService service;

    private ObjectMapper om = new ObjectMapper();


    @GET
    @RolesAllowed({"JOBSEEKER", "ADMIN"})
    @Path("vacancies/")
    public Response getVacancies() {
        try {
            String result = om.writeValueAsString(service.getAllVacancies());

            return Response.ok().entity(result).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }
    @GET
    @RolesAllowed({"JOBSEEKER", "ADMIN"})
    @Path("vacanciesFiltered/{year:[0-9]+}")
    public Response getVacanciesFilteredByDate(@PathParam("year") String sYear) {
        try {
            int year = Integer.parseInt(sYear);
            String result = om.writeValueAsString(service.getVacanciesFilteredByYear(year));

            return Response.ok().entity(result).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }

    @POST
    @RolesAllowed({"JOBSEEKER", "ADMIN"})
    @Path("sendVacancy/")
    @Consumes("application/json")
    public Response sendVacancyJms(String jsonVacancy) {
        try {
            Vacancy vacancy = om.readValue(jsonVacancy, Vacancy.class);
            String result = om.writeValueAsString(service.sendVacancyJms(vacancy));

            return Response.ok().entity(result).build();
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }



}
