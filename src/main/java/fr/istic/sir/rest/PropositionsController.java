package fr.istic.sir.rest;

import dao.PropositionsDAO;
import entities.Propositions;
import entities.Reunion;
import service.PropositionService;
import service.ReunionService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

@Path("/propositions")
public class PropositionsController {
    private PropositionsDAO propDao;
    private PropositionService service = new PropositionService();

    public PropositionsController(){
        propDao = new PropositionsDAO();
    }

    @GET
    @Path("/datesSondage/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Propositions> getAllDatesPropositions(@PathParam("id") int id){
        List<Propositions> prop = propDao.propositionsBySondage(1);
        for(Propositions p : prop){
            p.getSondage().setReponses(null);
            p.getSondage().setPropositions(null);
            p.getSondage().setCreat(null);
        }
        return prop;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Propositions addProposition(Propositions propositions) { return this.service.createProposition(propositions);}

}
