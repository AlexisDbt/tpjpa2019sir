package jpa;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Participant {

	private String email;
	private String nom;
	private String prenom;
	private ArrayList<Sondage> sondage;
	private ArrayList<Reunion> reunion;
	
	public Participant() {
		
	}
	
	public Participant (String email, String nom, String prenom) {
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		reunion = new ArrayList<Reunion>();
		sondage = new ArrayList<Sondage>();
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
}
