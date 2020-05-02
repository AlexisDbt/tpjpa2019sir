package dao;

import entities.Participant;
import entities.Sondage;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;

public class SondageDAO {
    EntityManager em = EntityManagerHelper.getEntityManager();

    public Sondage idSondage (int id) {
        return em.find(Sondage.class, id);
    }

    public List<Sondage> lienSondage (String lienWeb) {
        return em.createQuery("SELECT s FROM Sondage s WHERE s.lienWeb = :lienWeb", Sondage.class)
                .setParameter("lienWeb", lienWeb).getResultList();
    }

    /*
    public List<Sondage> createurSondage (Participant createur) {
        return em.createQuery("SELECT s, p FROM Sondage s, Participant p WHERE ") ??????
    }
    */

    public List<Sondage> allSondages() {
        return em.createQuery("SELECT s FROM Sondage s", Sondage.class).getResultList();
    }

    public Sondage save(Sondage s) {
        EntityManagerHelper.beginTransaction();
        if(s.getLienWeb() != null) {
            em.merge(s);
        } else {
            em.persist(s);
        }
        EntityManagerHelper.commit();
        return s;
    }

    public void delete(int id) {
        EntityManagerHelper.beginTransaction();
        em.remove(this.idSondage(id));
        EntityManagerHelper.commit();
    }
}
