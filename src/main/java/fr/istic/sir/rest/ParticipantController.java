package fr.istic.sir.rest;

import dao.ParticipantDAO;
import entities.Participant;
import service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/participants/list")
public class ParticipantController {
    private ParticipantDAO partDao;
    private UserService service = new UserService();

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Participant addParticipant(Participant participant) {
        return this.service.createParticipant(participant);
    }
}
