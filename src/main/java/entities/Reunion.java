package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Reunion")
public class Reunion {
	
	@Id
	@GeneratedValue
	private int id;
	private String intitule;
	private String resume;
	private Date date;
	private Set<Participant> invites;
	private Set<Participant> participants;
	private Set<Participant> absents;
	private Sondage sondage;
	private Mail mail;
	
	public Reunion() {
		
	}
	
	public Reunion(int id, String intitule, String resume, Date date){
		this.intitule = intitule;
		this.resume = resume;
		this.date = date;
		this.invites = new HashSet<Participant>();
		this.participants = new HashSet<Participant>();
		this.absents = new HashSet<Participant>();
		sondage = new Sondage();
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
	
	public void setInvites(Set<Participant> invites) {
		this.invites = invites;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	public Set<Participant> getInvites() {
		return invites;
	}
	
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	public Set<Participant> getParticipants() {
		return participants;
	}
	
	public void setPeigneCuls(Set<Participant> peigneCuls) {
		this.absents = peigneCuls;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	public Set<Participant> getPeigneCuls() {
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

	@OneToOne(cascade = CascadeType.MERGE)
	public Sondage getSondage() {
		return sondage;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Mail getMail() { return mail; }

	public void setMail(Mail mail) { this.mail = mail; }
}
