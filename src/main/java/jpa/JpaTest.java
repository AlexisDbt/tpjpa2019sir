package jpa;

import entities.Participant;
import entities.Propositions;
import entities.Reunion;
import entities.Sondage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaTest {

    static EntityManager manager = EntityManagerHelper.getEntityManager();

    /**
     * @param args
     */
    public static void main(String[] args) {

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            //createParticipant();
            //test.createSondage();
            createUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();
        //System.out.println(".. done");

    }


    private static void createParticipant() {
        int numPart = manager.createQuery("Select a From Participant a", Participant.class).getResultList().size();
        if (numPart == 0) {
            manager.persist(new Participant("elise.chapon@gmail.com", "Chap", "on"));
            manager.persist(new Participant("nanou@bn.com", "Nan", "ou"));
            manager.persist(new Participant("florentlaquiche@bn.com", "Quiche", "Florent"));
        }
    }
	/*
	public void createSondage() {
		int numSondage = manager.createQuery("Select a From Sondage a", Sondage.class).getResultList().size();
		if(numSondage == 0) {
			Participant p1 = new Participant("jesuisroux@oui.com", "Sarrazin", "Damien");
			Date date = new Date();
			Reunion reu = new Reunion(1, "ma reunion", "voila ma reunion", date);
			manager.persist(new Sondage(3, p1 , "lien", reu));
			manager.persist(new Participant("florentlaquiche@bn.com", "Quiche", "Florent"));
		}
	}*/

    public static void createUser() {

        Participant p1 = new Participant("exemple@ex.com", "exemple", "test");
        p1.setAllergie("gluten");

        manager.persist(p1);


        Reunion r1 = new Reunion("reunion1", "plan de deconfinement");
        Reunion r2 = new Reunion("reunion2", "");

        Sondage s1 = new Sondage(p1, "oui.lien");
        Propositions pr1 = new Propositions(new Date(), s1);

    }

}

