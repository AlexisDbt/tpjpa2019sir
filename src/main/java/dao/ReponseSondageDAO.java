package dao;

import entities.ReponseSondage;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;

public class ReponseSondageDAO {
    EntityManager em = EntityManagerHelper.getEntityManager();

    public ReponseSondage idReunionSondage(int id) {
        return em.find(ReponseSondage.class, id);
    }

    public List<ReponseSondage> nomParticipant (String nom) {
        return em.createQuery("SELECT rs FROM ReponseSondage rs WHERE rs.nom = :nom", ReponseSondage.class)
                .setParameter("nom", nom).getResultList();
    }

    public List<ReponseSondage> prenomParticipant (String prenom) {
        return em.createQuery("SELECT rs FROM ReponseSondage rs WHERE rs.prenom = :prenom", ReponseSondage.class)
                .setParameter("prenom", prenom).getResultList();
    }

    public List<ReponseSondage> emailParticipant (String email) {
        return em.createQuery("SELECT rs FROM ReponseSondage rs WHERE rs.email = :email", ReponseSondage.class)
                .setParameter("email", email).getResultList();
    }

    public List<ReponseSondage> allReponseSondage () {
        return em.createQuery("SELECT rs FROM ReponseSondage rs", ReponseSondage.class).getResultList();
    }

    public ReponseSondage save (ReponseSondage rs) {
        EntityManagerHelper.beginTransaction();
        if(rs.getEmail() != null) {
            em.merge(rs);
        } else {
            em.persist(rs);
        }
        EntityManagerHelper.commit();
        return rs;
    }

    public void delete (int id) {
        EntityManagerHelper.beginTransaction();
        em.remove(this.idReunionSondage(id));
        EntityManagerHelper.commit();
    }
}
