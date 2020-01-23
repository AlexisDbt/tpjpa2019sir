package jpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Allergies")
public class Allergies {

	@Id
	@GeneratedValue
	private Long id;
	private String libelle;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Participant> participant;
	
	public Allergies() {
		
	}
	
	public Allergies(Long id, String libelle) {
		this.id = id;
		this.libelle = libelle;
		participant = new HashSet<Participant>();
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
	
	public void setParticipant(Set<Participant> participant) {
		this.participant = participant;
	}
	
	public Set<Participant> getParticipant() {
		return participant;
	}
}
