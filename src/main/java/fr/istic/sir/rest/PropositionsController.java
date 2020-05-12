package fr.istic.sir.rest;

import dao.PropositionsDAO;
import entities.Propositions;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

@Path("/propositions")
public class PropositionsController {
    private PropositionsDAO propDao;

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

}
