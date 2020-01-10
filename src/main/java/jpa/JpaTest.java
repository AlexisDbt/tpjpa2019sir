package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class JpaTest {
	
	private static EntityManager manager;

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


		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
		 * 
		 */
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
			EntityManager manager = factory.createEntityManager();
			JpaTest test = new JpaTest(manager);

			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			try {
				test.createParticipant("mescouilles@gmail.com", "oui", "Chapon");
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();

				
	   	 	manager.close();
			System.out.println(".. done");
		
	}
	
	
	public void createParticipant(String email, String nom, String prenom) {
		int numPart = manager.createQuery("Select x From Participant x", Participant.class).getResultList().size();
		if(numPart == 0) {
			manager.persist(new Participant(email, nom, prenom));
		}
	}
	
	public void createSondage() {
		
	}
	
	
	


}
