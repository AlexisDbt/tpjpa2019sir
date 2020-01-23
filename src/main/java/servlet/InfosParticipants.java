package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JpaTest;
import jpa.Participant;

@WebServlet(name = "infosparticipants", urlPatterns = { "/InfosParticipants" })
public class InfosParticipants extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
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

			
   	 	//manager.close();
		System.out.println(".. done");
		
		List<Participant> participant =  manager.createQuery("Select a From Participant a", Participant.class).getResultList();
		
		out.println("<HTML>\n<BODY>\n" 
				  + "<H1>Recapitulatif des informations</H1>\n" 
				  + "<UL>\n" 
				  + " <LI>Email: "
				  + participant.get(1).getEmail()
				  + "\n" 
				  + " <LI>Nom: " 
				  + participant.get(0).getNom()
				  + "\n"
				  + " <LI>Prenom: " 
				  + participant.get(2).getPrenom() 
				  + "\n" 
				  + "</UL>\n" 
				  + "</BODY></HTML>");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		
			String email = request.getParameter("email");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			
			manager.persist(new Participant(email, nom, prenom));
			
			PrintWriter out = response.getWriter();
			
			out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n" + " <LI>Email: "
					+ request.getParameter("email") + "\n" + " <LI>Nom: " + request.getParameter("nom") + "\n"
					+ " <LI>Prenom: " + request.getParameter("prenom") + "\n" + "</UL>\n" + "</BODY></HTML>");
			
			tx.commit();
	}
	

}
