package fr.istic.sir.rest;

import dao.ParticipantDAO;
import entities.Participant;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/participants")
public class ParticipantController {
    private ParticipantDAO dao;

    public ParticipantController(){
        dao = new ParticipantDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Participant> getAllParticipants(){
        return dao.allParticipants();
    }
}
