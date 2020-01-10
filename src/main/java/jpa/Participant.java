package jpa;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="Participant")
public class Participant {

	private String email;
	private String nom;
	private String prenom;
	private ArrayList<Sondage> sondage;
	private ArrayList<Reunion> reunion;
	private ArrayList<Preferences> preferences;
	private ArrayList<Allergies> allergies;
	private Mail mail;
	
	public Participant() {
		
	}
	
	public Participant (String email, String nom, String prenom) {
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		reunion = new ArrayList<Reunion>();
		sondage = new ArrayList<Sondage>();
		preferences = new ArrayList<Preferences>();
		allergies = new ArrayList<Allergies>();
		mail = new Mail();
	}
	
	@Id
	@GeneratedValue
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
	
	public void setReunion(ArrayList<Reunion> reunion) {
		this.reunion = reunion;
	}
	
	@ManyToMany
	@JoinTable(name="Participants_Réunion", joinColumns=@JoinColumn(name="Participant"), inverseJoinColumns=@JoinColumn(name="Réunion"))
	public ArrayList<Reunion> getReunion() {
		return reunion;
	}
	
	public void setSondage(ArrayList<Sondage> sondage) {
		this.sondage = sondage;
	}
	
	@OneToMany
	public ArrayList<Sondage> getSondage() {
		return sondage;
	}
	
	public void setAllergies(ArrayList<Allergies> allergies) {
		this.allergies = allergies;
	}
	
	@ManyToMany
	@JoinTable(name="Participants_Allergies", joinColumns=@JoinColumn(name="Participant"), inverseJoinColumns=@JoinColumn(name="Allergie"))
	public ArrayList<Allergies> getAllergies() {
		return allergies;
	}
	
	public void setPreferences(ArrayList<Preferences> preferences) {
		this.preferences = preferences;
	}
	
	@ManyToMany
	@JoinTable(name="Participants_Preferences", joinColumns=@JoinColumn(name="Participant"), inverseJoinColumns=@JoinColumn(name="Preference"))
	public ArrayList<Preferences> getPreferences() {
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
