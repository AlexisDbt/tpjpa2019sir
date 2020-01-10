package jpa;

import javax.persistence.*;

@Entity
@Table(name="Allergies")
public class Allergies {

	private Long id;
	private String libelle;
	private Participant participant;
	
	public Allergies() {
		
	}
	
	public Allergies(Long id, String libelle) {
		this.id = id;
		this.libelle = libelle;
		participant = new Participant();
	}
	
	@Id
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	
	@ManyToMany(mappedBy = "participants")
	public Participant getParticipant() {
		return participant;
	}
}
