package dao;

import entities.Participant;
import entities.Sondage;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;

public class SondageDAO {
    EntityManager em = EntityManagerHelper.getEntityManager();

    public Sondage sondageById (int id) {
        return em.find(Sondage.class, id);
    }

    public List<Sondage> sondageByLienWeb (String lienWeb) {
        return em.createQuery("select s from Sondage s where s.lienWeb = :lienWeb", Sondage.class)
                .setParameter("lienWeb", lienWeb).getResultList();
    }

    public List<Sondage> sondageByCreateur (String email) {
        return em.createQuery("select s from Sondage s where s.participant.email = :email", Sondage.class)
                .setParameter("email", email).getResultList();
    }

    public List<Sondage> sondageByRepSondage (int idRepSondage) {
        return em.createQuery("select s from Sondage s where s.ReponseSondage.id = :idRepSondage", Sondage.class)
                .setParameter("idRepSondage", idRepSondage).getResultList();
    }

    public List<Sondage> sondageByPropositions (int idProposition) {
        return em.createQuery("select s from Sondage s where s.propositions.id = :idProposition", Sondage.class)
                .setParameter("idProposition", idProposition).getResultList();
    }
    public List<Sondage> allSondages() {
        return em.createQuery("SELECT s FROM Sondage s", Sondage.class).getResultList();
    }

    public Sondage save(Sondage s ){
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(s);
            EntityManagerHelper.commit();
        } catch (Exception ex) {
            EntityManagerHelper.rollback();
        }

        return s;
    }
}
