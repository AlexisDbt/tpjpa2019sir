package fr.istic.sir.rest;

import dao.ReunionDAO;
import entities.Reunion;
import service.ReunionService;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reunion")
public class ReunionController {
    private ReunionDAO reuDAO;
    private ReunionService service = new ReunionService();

    public ReunionController() { reuDAO = new ReunionDAO(); }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reunion addReunion(Reunion reunion) { return this.service.createReunion(reunion);}
}
