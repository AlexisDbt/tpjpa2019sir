package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name="Sondage")
public class Sondage {

	@Id
	@GeneratedValue
	private int id;
	private String lienWeb;
	private Participant createur;
	private Reunion reunion;
	private List<ReponseSondage> reponses = new ArrayList<ReponseSondage>();
	
	public Sondage() {
		
	}
	
	public Sondage (Participant createur, String lienWeb) {
		this.createur = createur;
		this.lienWeb = lienWeb;
	}
	
	public void setCreateur(Participant createur) {
		this.createur = createur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Participant getCreateur() {
		return createur;
	}

	public void setId(int id) {
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

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "sondage", fetch = FetchType.LAZY)
	public List<ReponseSondage> getReponses() {
		return reponses;
	}

	public void setReponses(List<ReponseSondage> reponses) {
		this.reponses = reponses;
	}
}
