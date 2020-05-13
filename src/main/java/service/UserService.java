package service;

import dao.ParticipantDAO;
import entities.Participant;

public class UserService {
    private ParticipantDAO dao = new ParticipantDAO();

    public Participant createParticipant(Participant participant) {
        return this.dao.save(participant);
    }
}
