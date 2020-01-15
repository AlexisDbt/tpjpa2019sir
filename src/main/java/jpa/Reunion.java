package jpa;
import java.util.Date;
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
	@OneToMany
	private ArrayList<Participant> invites;
	@OneToMany
	private ArrayList<Participant> participants;
	@OneToMany
	private ArrayList<Participant> peigneCuls;
	@OneToOne
	private Sondage sondage;
	
	public Reunion() {
		
	}
	
	public Reunion(int id, String intitule, String resume, Date date){
		this.intitule = intitule;
		this.resume = resume;
		this.date = date;
		this.invites = new ArrayList<Participant>();
		this.participants = new ArrayList<Participant>();
		this.peigneCuls = new ArrayList<Participant>();		
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
	
	public void setInvites(ArrayList<Participant> invites) {
		this.invites = invites;
	}
	
	public ArrayList<Participant> getInvites() {
		return invites;
	}
	
	public void setParticipants(ArrayList<Participant> participants) {
		this.participants = participants;
	}
	
	public ArrayList<Participant> getParticipants() {
		return participants;
	}
	
	public void setPeigneCuls(ArrayList<Participant> peigneCuls) {
		this.peigneCuls = peigneCuls;
	}
	
	public ArrayList<Participant> getPeigneCuls() {
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
