package jpa;

import entities.Participant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {
	
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		EntityManagerHelper.closeEntityManagerFactory();
		factory.close();
		 */

		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		//EntityManager manager = factory.createEntityManager();
		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createParticipant();
			//test.createSondage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
		
	}
	
	
	public void createParticipant() {
		int numPart = manager.createQuery("Select a From Participant a", Participant.class).getResultList().size();
		if(numPart == 0) {
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
			manager.persist(new Participant("grossesalope@connasse.com", "Nan", "ou"));
			manager.persist(new Participant("florentlaquiche@bn.com", "Quiche", "Florent"));
		}
	}*/
	
	
	


}
