package jpa;

import javax.persistence.*;

@Entity
public class Sondage {
	
	private long id;
	private String lienWeb;
	private Participant createur;
	private Reunion reunion;
	
	public Sondage() {
		
	}
	
	public Sondage (Long id, Participant createur, String lienWeb, Reunion reunion) {
		this.createur = createur;
		this.id = id;
		this.lienWeb = lienWeb;
		this.reunion = reunion;
	}
	
	public void setCreateur(Participant createur) {
		this.createur = createur;
	}
	
	@ManyToOne
	public Participant getCreateur() {
		return createur;
	}
	
	@Id
	@GeneratedValue
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setLienWeb(String lienWeb) {
		this.lienWeb = lienWeb;
	}
	
	public String getLienWeb() {
		return lienWeb;
	}
	
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	
	@OneToOne
	public Reunion getReunion() {
		return reunion;
	}
}
