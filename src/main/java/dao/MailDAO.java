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

    public List<Mail> liensPadMail(String lienPad) {
        return em.createQuery("SELECT m FROM Mail m WHERE m.lienPad = :lienPad", Mail.class)
                .setParameter("lienPad", lienPad).getResultList();
    }

    public List<Mail> participantMail (Participant participant) {
        return null;
    }

    public List<Mail> reunionMail (Reunion reunion) {
        return null;
    }

    public List<Mail> allMail() {
        return em.createQuery("SELECT m FROM Mail m", Mail.class)
                .getResultList();
    }

    public Mail save (Mail m){
        EntityManagerHelper.beginTransaction();
        if(m.getLienPad() != null) {
            em.merge(m);
        } else {
            em.persist(m);
        }
        EntityManagerHelper.commit();
        return m;
    }

    public void delete(int id) {
        EntityManagerHelper.beginTransaction();
        em.remove(this.idMail(id));
        EntityManagerHelper.commit();
    }
}
