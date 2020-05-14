package dao;

import entities.Reunion;
import entities.Sondage;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class ReunionDAO {
    EntityManager em = EntityManagerHelper.getEntityManager();

    public Reunion reunionById (int id) {
        return em.find(Reunion.class, id);
    }

    public List<Reunion> reunionByIntitule(String intitule) {
        return em.createQuery("select r from Reunion r where r.intitule = :intitule", Reunion.class)
                .setParameter("intitule", intitule).getResultList();
    }

    public List<Reunion> reunionByResume(String resume) {
        return em.createQuery("select r from Reunion r where r.resume = :resume", Reunion.class)
                .setParameter("resume", resume).getResultList();
    }

    public List<Reunion> reunionByDate(Date date) {
        return em.createQuery("select r from Reunion r where r.date = :date", Reunion.class)
                .setParameter("date", date).getResultList();
    }

    public List<Reunion> reunionByParticipants(String email) {
        return em.createQuery("select r from Reunion r where r.participant.email = :email", Reunion.class)
                .setParameter("email", email).getResultList();
    }

    public List<Reunion> reunionByMail(int idMail) {
        return em.createQuery("select r from Reunion r where r.mail.id = :id", Reunion.class)
                .setParameter("idMail", idMail).getResultList();
    }

    public List<Reunion> allReunions() {
        return em.createQuery("select r from Reunion r").getResultList();
    }

    public Reunion save(Reunion r ){
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(r);
            EntityManagerHelper.commit();
        } catch (Exception ex) {
            EntityManagerHelper.rollback();
        }

        return r;
    }

}
