package entities;

import java.util.ArrayList;
import java.util.List;


import javax.naming.Name;
import javax.persistence.*;

@Entity
public class Participant {

	private String email;
	private String nom;
	private String prenom;
	private String allergie;
	private String preferenceAlim;
	private List<Mail> mails = new ArrayList<Mail>();
	private List<Sondage> sondages = new ArrayList<Sondage>();
	private List<Reunion> reunions = new ArrayList<Reunion>();
	
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

	@Id
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

	@OneToMany(fetch=FetchType.LAZY, mappedBy="creat", cascade = CascadeType.PERSIST)
	public List<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
	}

	@ManyToMany
	/*@JoinTable(
			name="participant_reunions",
			joinColumns = @JoinColumn(name="participant_id"),
			inverseJoinColumns = @JoinColumn(name="reunion_id"))*/
	public List<Reunion> getReunions() { return reunions; }

	public void setReunions(List<Reunion> reunions) { this.reunions = reunions; }

	@ManyToMany
	/*@JoinTable(
			name = "participant_mail",
			joinColumns = @JoinColumn(name = "email"),
			inverseJoinColumns = @JoinColumn(name = "mail_id"))*/
	public List<Mail> getMails() { return mails; }

	public void setMails(List<Mail> mails) { this.mails = mails; }
}
