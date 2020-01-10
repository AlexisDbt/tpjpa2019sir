package jpa;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="Reunion")
public class Reunion {
	
	private int id;
	private String intitule;
	private String resume;
	private Date date;
	private ArrayList<Participant> invites;
	private ArrayList<Participant> participants;
	private ArrayList<Participant> peigneCuls;
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
	
	@Id
	@GeneratedValue
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
	
	@OneToMany
	public ArrayList<Participant> getInvites() {
		return invites;
	}
	
	public void setParticipants(ArrayList<Participant> participants) {
		this.participants = participants;
	}
	
	@OneToMany
	public ArrayList<Participant> getParticipants() {
		return participants;
	}
	
	public void setPeigneCuls(ArrayList<Participant> peigneCuls) {
		this.peigneCuls = peigneCuls;
	}
	
	@OneToMany
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
	
	@OneToOne
	public Sondage getSondage() {
		return sondage;
	}
	
	
}
