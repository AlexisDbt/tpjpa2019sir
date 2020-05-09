package dao;

import entities.Participant;
import entities.ReponseSondage;
import entities.Sondage;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;

public class ReponseSondageDAO {
    EntityManager em = EntityManagerHelper.getEntityManager();

    public ReponseSondage reponseSondageById(int id) {
        return em.find(ReponseSondage.class, id);
    }

    public List<ReponseSondage> reponseSondageByNom (String nom) {
        return em.createQuery("select rs from ReponseSondage rs where rs.nom = :nom", ReponseSondage.class)
                .setParameter("nom", nom).getResultList();
    }

    public List<ReponseSondage> reponseSondageByPreom (String prenom) {
        return em.createQuery("select rs from ReponseSondage rs where rs.prenom = :prenom", ReponseSondage.class)
                .setParameter("prenom", prenom).getResultList();
    }

    public List<ReponseSondage> reponseSondageByEmail (String email) {
        return em.createQuery("select rs from ReponseSondage rs where rs.email = :email", ReponseSondage.class)
                .setParameter("email", email).getResultList();
    }

    public List<ReponseSondage> reponseSondageBySondage(int idSondage) {
        return em.createQuery("select rs from ReponseSondage rs where rs.sondage.id = :idSondage", ReponseSondage.class)
                .setParameter("idSondage", idSondage).getResultList();
    }

    public List<ReponseSondage> allReponsesSondage () {
        return em.createQuery("select rs from ReponseSondage rs", ReponseSondage.class).getResultList();
    }
}
