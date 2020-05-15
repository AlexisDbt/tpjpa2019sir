package fr.istic.sir.rest;

import dao.ReunionDAO;
import entities.Reunion;
import service.ReunionService;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/reunion/list")
public class ReunionController {
    private ReunionDAO reuDAO;
    private ReunionService service = new ReunionService();

    public ReunionController() { reuDAO = new ReunionDAO(); }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reunion addReunion(Reunion reunion) { return this.service.createReunion(reunion);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reunion> getAllReunions(){
        List<Reunion> reunions = reuDAO.allReunions();
        return reunions;
    }
}
