package jpa;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

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
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Participant> invites;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Participant> participants;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Participant> peigneCuls;
	@OneToOne(cascade = CascadeType.MERGE)
	private Sondage sondage;
	@ManyToOne(cascade = CascadeType.ALL)
	private Mail mail;
	
	public Reunion() {
		
	}
	
	public Reunion(int id, String intitule, String resume, Date date){
		this.intitule = intitule;
		this.resume = resume;
		this.date = date;
		this.invites = new HashSet<Participant>();
		this.participants = new HashSet<Participant>();
		this.peigneCuls = new HashSet<Participant>();		
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
	
	public Set<Participant> getInvites() {
		return invites;
	}
	
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}
	
	public Set<Participant> getParticipants() {
		return participants;
	}
	
	public void setPeigneCuls(Set<Participant> peigneCuls) {
		this.peigneCuls = peigneCuls;
	}
	
	public Set<Participant> getPeigneCuls() {
		return peigneCuls;
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
	
	public Sondage getSondage() {
		return sondage;
	}
	
	
}
