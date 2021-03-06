package dao;

import entities.Propositions;
import entities.Reunion;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class PropositionsDAO {
    EntityManager em = EntityManagerHelper.getEntityManager();

    public List<Propositions> allPropositions(){
        return em.createQuery("select p from Propositions p").getResultList();
    }

    public Propositions propositionsById(int id){
        return em.find(Propositions.class, id);
    }

    public List<Propositions> propositionsByDate(Date date){
        return em.createQuery("select p from Propositions p where p.date = :date", Propositions.class).setParameter("date", date).getResultList();
    }

    public List<Propositions> propositionsBySondage(int idSondage){
        return em.createQuery("select p from Propositions p where p.sondage.id = :idSondage", Propositions.class).setParameter("idSondage", idSondage).getResultList();
    }

    public Propositions save(Propositions p ){
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
