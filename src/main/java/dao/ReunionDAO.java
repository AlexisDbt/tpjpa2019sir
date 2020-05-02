package dao;

import entities.Reunion;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;

public class ReunionDAO {
    EntityManager em = EntityManagerHelper.getEntityManager();

    public Reunion idReunion (int id) {
        return em.find(Reunion.class, id);
    }

    public List<Reunion> intituleReunion(String intitule) {
        return em.createQuery("SELECT r FROM Reunion r WHERE r.intitule = :intitule", Reunion.class)
                .setParameter("intitule", intitule).getResultList();
    }

    public List<Reunion> allReunion() {
        return em.createQuery("SELECT r FROM Reunion r").getResultList();
    }

    public Reunion save (Reunion r) {
        EntityManagerHelper.beginTransaction();
        if (r.getIntitule() != null) {
            em.merge(r);
        } else {
            em.persist(r);
        }
        EntityManagerHelper.commit();
        return r;
    }

    public void delete (int id) {
        EntityManagerHelper.beginTransaction();
        em.remove(this.idReunion(id));
        EntityManagerHelper.commit();
    }
}
