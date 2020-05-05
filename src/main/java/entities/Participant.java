package entities;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

@Entity
//@Table(name="Participant")
public class Participant {

	@Id
	private String email;
	private String nom;
	private String prenom;
	private String allergie;
	private String preferenceAlim;
	private List<Mail> mail = new ArrayList<Mail>();
	private List<Sondage> sondage = new ArrayList<Sondage>();
	private List<Reunion> reunion = new ArrayList<Reunion>();
	
	public Participant() {
		
	}
	
	public Participant (String email, String nom, String prenom) {
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
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

	public String getAllergie() {
		return allergie;
	}

	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}

	public String getPreferenceAlim() {
		return preferenceAlim;
	}

	public void setPreferenceAlim(String preferenceAlim) {
		this.preferenceAlim = preferenceAlim;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="createur", cascade = CascadeType.PERSIST)
	public List<Sondage> getSondage() {
		return sondage;
	}

	public void setSondage(List<Sondage> sondage) {
		this.sondage = sondage;
	}

	@ManyToMany
	@JoinTable(
			name="participants_reunions",
			joinColumns = @JoinColumn(name="participant_id"),
			inverseJoinColumns = @JoinColumn(name="reunion_id"))
	public List<Reunion> getReunion() {
		return reunion;
	}

	public void setReunion(List<Reunion> reunion) {
		this.reunion = reunion;
	}

	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
			name = "participants_mails",
			joinColumns = @JoinColumn(name = "participant_id"),
			inverseJoinColumns = @JoinColumn(name = "mail_id"))
	public List<Mail> getMail() {
		return mail;
	}

	public void setMail(List<Mail> mail) {
		this.mail = mail;
	}
}
