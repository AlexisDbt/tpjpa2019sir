package jpa;

import javax.persistence.*;

@Entity
@Table(name="Preferences")
public class Preferences {

	@Id
	@GeneratedValue
	private Long id;
	private String libelle;
	@ManyToMany(mappedBy = "participants")
	private Participant participant;
	
	public Preferences () {
		
	}
	
	public Preferences (Long id, String libelle) {
		this.id = id;
		this.libelle = libelle;
		participant = new Participant();
	}
	
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
	
	public Participant getParticipant() {
		return participant;
	}
}
