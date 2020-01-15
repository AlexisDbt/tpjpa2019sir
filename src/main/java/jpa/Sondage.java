package jpa;

import javax.persistence.*;

@Entity
@Table(name="Sondage")
public class Sondage {
	
	@Id
	@GeneratedValue
	private long id;
	private String lienWeb;
	@ManyToOne
	private Participant createur;
	@OneToOne
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
	
	public Participant getCreateur() {
		return createur;
	}
	
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
	
	public Reunion getReunion() {
		return reunion;
	}
}
