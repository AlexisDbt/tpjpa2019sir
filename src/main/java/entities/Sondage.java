package entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sondage {
	private int id;
	private String lienWeb;
	private Participant createur;
	private List<ReponseSondage> reponses = new ArrayList<ReponseSondage>();
	private List<Propositions> propositions = new ArrayList<Propositions>();
	
	public Sondage() {
		
	}
	
	public Sondage (Participant createur, String lienWeb) {
		this.createur = createur;
		this.lienWeb = lienWeb;
	}
	
	public void setCreat(Participant createur) {
		this.createur = createur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Participant getCreat() {
		return createur;
	}

	@Id
	@GeneratedValue
	public int getId() { return id; }

	public void setId(int id) { this.id = id; }
	
	public void setLienWeb(String lienWeb) {
		this.lienWeb = lienWeb;
	}
	
	public String getLienWeb() {
		return lienWeb;
	}

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "sondage", fetch = FetchType.LAZY)
	public List<ReponseSondage> getReponses() { return reponses; }

	public void setReponses(List<ReponseSondage> reponses) { this.reponses = reponses; }

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "sondage", fetch = FetchType.LAZY)
	public List<Propositions> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Propositions> propositions) {
		this.propositions = propositions;
	}

}
