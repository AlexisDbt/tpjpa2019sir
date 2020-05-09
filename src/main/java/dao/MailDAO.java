package dao;

import entities.Mail;
import entities.Participant;
import entities.Reunion;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;

public class MailDAO {
    EntityManager em = EntityManagerHelper.getEntityManager();

    public Mail idMail (int id) {
        return em.find(Mail.class, id);
    }

    public List<Mail> mailByLienPad(String lienPad) {
        return em.createQuery("SELECT m FROM Mail m WHERE m.lienPad = :lienPad", Mail.class)
                .setParameter("lienPad", lienPad).getResultList();
    }

    public List<Mail> mailByParticipant (String mailParticipant) {
        return em.createQuery("select m from Mail m where m.participant.email = :mailParticipant", Mail.class)
                .setParameter("mailParticipant", mailParticipant).getResultList();
    }

    public List<Mail> mailByReunion (int idReunion) {
        return em.createQuery("select m from Mail m where m.reunion.id = :idReunion", Mail.class)
                .setParameter("idReunion", idReunion).getResultList();
    }

    public List<Mail> mailByLienPause (String lienPause) {
        return em.createQuery("select m from m where m.lienPause = :lienPause", Mail.class)
                .setParameter("lienPause", lienPause).getResultList();
    }

    public List<Mail> mailByCode (String code) {
        return em.createQuery("select m from Mail where m.code = :code", Mail.class)
                .setParameter("code", code).getResultList();
    }

    public List<Mail> allMails() {
        return em.createQuery("SELECT m FROM Mail m", Mail.class)
                .getResultList();
    }
}
