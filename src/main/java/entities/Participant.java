package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Participant")
public class Participant {

	@Id
	private String email;
	private String nom;
	private String prenom;
	private String allergie;
	private String preferenceAlim;
	private Set<Sondage> sondage;
	private Set<Reunion> reunion;
	private Mail mail;
	
	public Participant() {
		
	}
	
	public Participant (String email, String nom, String prenom) {
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		reunion = new HashSet<Reunion>();
		sondage = new HashSet<Sondage>();
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

	public String getAllergie() { return allergie;	}

	public void setAllergie(String allergie) { this.allergie = allergie; }

	public String getPreferenceAlim() { return preferenceAlim; }

	public void setPreferenceAlim(String preferenceAlim) { this.preferenceAlim = preferenceAlim; }

	@OneToMany(mappedBy="createur", cascade = CascadeType.MERGE)
	public Set<Sondage> getSondage() {
		return sondage;
	}

	public void setSondage(Set<Sondage> sondage) {
		this.sondage = sondage;
	}

	@ManyToMany(mappedBy="participants", cascade = CascadeType.ALL)
	public Set<Reunion> getReunion() {
		return reunion;
	}

	public void setReunion(Set<Reunion> reunion) {
		this.reunion = reunion;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}
}
