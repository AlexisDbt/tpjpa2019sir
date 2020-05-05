package entities;

import java.util.*;

import javax.persistence.*;

@Entity
//@Table(name="Reunion")
public class Reunion {
	
	@Id
	@GeneratedValue
	private int id;
	private String intitule;
	private String resume;
	@Temporal(TemporalType.DATE)
	private Date date;
	private List<Participant> invites = new ArrayList<Participant>();
	private List<Participant> participants = new ArrayList<Participant>();
	private List<Participant> absents = new ArrayList<Participant>();
	private Sondage sondage =  new Sondage();
	private Mail mail = new Mail();
	
	public Reunion() {
		
	}
	
	public Reunion(String intitule, String resume){
		this.intitule = intitule;
		this.resume = resume;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	public String getIntitule() {
		return intitule;
	}
	
	public void setInvites(List<Participant> invites) {
		this.invites = invites;
	}

	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "reunion", fetch = FetchType.LAZY)
	public List<Participant> getInvites() {
		return invites;
	}
	
	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "reunion", fetch = FetchType.LAZY)
	public List<Participant> getParticipants() {
		return participants;
	}
	
	public void setAbsents(List<Participant> absents) {
		this.absents = absents;
	}

	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "reunion", fetch = FetchType.LAZY)
	public List<Participant> getAbsents() {
		return absents;
	}
	
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public String getResume() {
		return resume;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	public Sondage getSondage() {
		return sondage;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}
}
