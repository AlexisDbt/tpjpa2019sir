package dao;

import entities.Mail;
import entities.Participant;
import entities.Reunion;
import entities.Sondage;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;

public class ParticipantDAO {
    EntityManager em = EntityManagerHelper.getEntityManager();

    public Participant participantByEmail(String email) {
        Participant p = (Participant) em.createQuery("select p from Participant p where p.email = :email" )
                .setParameter("email",email).getSingleResult();
        return p;
    }

    public List<Participant> participantByNom(String nom) {
        return em.createQuery("select p from Participant p where p.nom = :nom", Participant.class)
                .setParameter("nom", nom).getResultList();
    }

    public List<Participant> participantByPrenom(String prenom) {
        return em.createQuery("select p from Participant p where p.prenom = :prenom", Participant.class)
                .setParameter("prenom", prenom).getResultList();
    }

    public List<Participant> participantByAllergies(String allergie) {
        return em.createQuery("select p from Participant p where p.allergie = :allergie", Participant.class)
                .setParameter("allergie", allergie).getResultList();
    }

    public List<Participant> participantByPrefAlim(String prefAlim) {
        return em.createQuery("select p from Participant p where p.preferenceAlim = :prefAlim", Participant.class)
                .setParameter("prefAlim", prefAlim).getResultList();
    }

    public List<Participant> participantByReunion(int idReunion) {
        return em.createQuery("select p from Participant p where p.reunion.id = :idReunion", Participant.class)
                .setParameter("idReunion", idReunion).getResultList();
    }

    public List<Participant> participantByMail(int idMail) {
        return em.createQuery("select p from Participant p where p.mail.id = :idMail", Participant.class)
                .setParameter("idMail", idMail).getResultList();
    }

    public List<Participant> participantBySondage(int idSondage) {
        return em.createQuery("select p from Participant p where p.sondage.id = :idSondage", Participant.class)
                .setParameter("idSondage", idSondage).getResultList();
    }
    public List<Participant> allParticipants(){
        return em.createQuery("select p from Participant p").getResultList();
    }

    public Participant save(Participant p ){
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(p);
            EntityManagerHelper.commit();
        } catch (Exception ex) {
            EntityManagerHelper.rollback();
        }

        return p;
    }
}
