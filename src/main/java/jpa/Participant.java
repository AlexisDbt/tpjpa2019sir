package jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="Participant")
public class Participant {

	@Id
	@GeneratedValue
	private String email;
	private String nom;
	private String prenom;
	@OneToMany(mappedBy="createur")
	private Set<Sondage> sondage;
	@ManyToMany(mappedBy="participants")
	private Set<Reunion> reunion;
	@ManyToMany(mappedBy="participant")	
	private Set<Preferences> preferences;
	@ManyToMany(mappedBy="participant")
	private Set<Allergies> allergies;
	@ManyToOne
	private Mail mail;
	
	public Participant() {
		
	}
	
	public Participant (String email, String nom, String prenom) {
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		reunion = new HashSet<Reunion>();
		sondage = new HashSet<Sondage>();
		preferences = new HashSet<Preferences>();
		allergies = new HashSet<Allergies>();
		mail = new Mail();
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setReunion(Set<Reunion> reunion) {
		this.reunion = reunion;
	}
	
	public Set<Reunion> getReunion() {
		return reunion;
	}
	
	public void setSondage(Set<Sondage> sondage) {
		this.sondage = sondage;
	}
	
	public Set<Sondage> getSondage() {
		return sondage;
	}
	
	public void setAllergies(Set<Allergies> allergies) {
		this.allergies = allergies;
	}
	
	public Set<Allergies> getAllergies() {
		return allergies;
	}
	
	public void setPreferences(Set<Preferences> preferences) {
		this.preferences = preferences;
	}
	
	public Set<Preferences> getPreferences() {
		return preferences;
	}
	
	/**public void setMail(Mail mail) {
		this.mail = mail;
	}
	
	@OneToOne
	public Mail getMail() {
		return mail;
	}*/
}
