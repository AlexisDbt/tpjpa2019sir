package dao;

import entities.Participant;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;

public class ParticipantDAO {
    EntityManager em = EntityManagerHelper.getEntityManager();

    public Participant participantEmail(String email) {
        Participant p = (Participant) em.createQuery("SELECT p FROM Participant p WHERE p.id = :email" )
                .setParameter("email",email).getSingleResult();
        return p;
    }

    public List<Participant> participantsNom(String nom) {
        return em.createQuery("SELECT email, prenom FROM Participant p WHERE p.nom = :nom", Participant.class)
                .setParameter("nom", nom).getResultList();
    }

    public List<Participant> participantsPrenom(String prenom) {
        return em.createQuery("SELECT p FROM Participant p WHERE p.prenom = :prenom", Participant.class)
                .setParameter("prenom", prenom).getResultList();
    }

    public List<Participant> allParticipants(){
        return em.createQuery("SELECT p FROM Participant p").getResultList();
    }

    public Participant save (Participant p) {
        EntityManagerHelper.beginTransaction();
        if(p.getEmail() != null) {
            em.merge(p);
        } else {
            em.persist(p);
        }
        EntityManagerHelper.commit();
        return p;
    }

    public void delete(String email) {
        EntityManagerHelper.beginTransaction();
        em.remove(this.participantEmail(email));
        EntityManagerHelper.commit();
    }

}
