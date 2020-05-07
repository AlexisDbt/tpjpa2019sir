package fr.istic.sir.rest;

import dao.PropositionsDAO;
import entities.Propositions;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sondage")
public class PropositionsController {
    private PropositionsDAO propDao;

    public PropositionsController(){
        propDao = new PropositionsDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Propositions getAllDatesPropositions(){
        return propDao.propositionsById(1);
    }
}
