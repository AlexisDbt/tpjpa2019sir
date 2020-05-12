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

@Path("/participants/list")
public class ParticipantController {
    private ParticipantDAO partDao;

    public ParticipantController(){
        partDao = new ParticipantDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Participant> getAllParticipants(){
        List<Participant> participants = partDao.allParticipants();
        for(Participant p : participants){
            p.setSondages(null);
        }
        return participants;
    }
}
