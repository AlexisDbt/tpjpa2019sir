package fr.istic.sir.rest;

import dao.ParticipantDAO;
import dao.PropositionsDAO;
import entities.Participant;
import entities.Propositions;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/participants")
public class ParticipantController {
    private ParticipantDAO partDao;
    private PropositionsDAO propDao;

    public ParticipantController(){
        partDao = new ParticipantDAO();
        propDao = new PropositionsDAO();
    }

    /**@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Participant> getAllParticipants(){
        return partDao.allParticipants();
    }*/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Propositions> getAllDatesPropositions(){
        return propDao.allPropositions();
    }
}
