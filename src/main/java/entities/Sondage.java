package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sondage {
	private int id;
	private String lienWeb;
	private Participant creat;
	private Reunion reunion;
	private List<ReponseSondage> reponses = new ArrayList<ReponseSondage>();
	
	public Sondage() {
		
	}
	
	public Sondage (Participant creat, String lienWeb) {
		this.creat = creat;
		this.lienWeb = lienWeb;
	}
	
	public void setCreat(Participant creat) {
		this.creat = creat;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Participant getCreat() {
		return creat;
	}

	@Id
	@GeneratedValue
	public long getId() { return id; }

	public void setId(int id) { this.id = id; }
	
	public void setLienWeb(String lienWeb) {
		this.lienWeb = lienWeb;
	}
	
	public String getLienWeb() {
		return lienWeb;
	}
	
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	@OneToOne(mappedBy="sondage")
	public Reunion getReunion() { return reunion; }

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "sondage", fetch = FetchType.LAZY)
	public List<ReponseSondage> getReponses() { return reponses; }

	public void setReponses(List<ReponseSondage> reponses) { this.reponses = reponses; }
}
