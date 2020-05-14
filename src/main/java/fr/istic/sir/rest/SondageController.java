package fr.istic.sir.rest;

import dao.SondageDAO;
import entities.Sondage;
import service.SondageService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sondage")
public class SondageController {
    private SondageDAO sondDao;
    private SondageService service = new SondageService();

    public SondageController() { sondDao = new SondageDAO(); }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sondage addSondage(Sondage sondage) { return this.service.createSondage(sondage);}
}
