package entities;
import entities.Participant;
import entities.Reunion;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Mail")
public class Mail {
	
	@OneToMany(mappedBy="mail", cascade = CascadeType.ALL)
	private Set<Participant> participant;
	@OneToMany(mappedBy="mail", cascade = CascadeType.ALL)
	private Set<Reunion> reunion;
	private String lienPause;
	private String code;
	private String lienPad;
	@Id
	@GeneratedValue
	private Long id;
	
	public Mail() {
		
	}
	
	public Mail(Long id, String lienPause, String code, String lienPad) {
		this.code = code;
		this.lienPad = lienPad;
		this.lienPause = lienPause;
		this.id = id;
		participant = new HashSet<Participant>();
		reunion = new HashSet<Reunion>();
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setLienPad(String lienPad) {
		this.lienPad = lienPad;
	}
	
	public String getLienPad() {
		return lienPad;
	}
	
	public void setLienPause(String lienPause) {
		this.lienPause = lienPause;
	}
	
	public String getLienPause() {
		return lienPause;
	}
	
	
	public void setParticipant(Set<Participant> participant) {
		this.participant = participant;
	}
	
	public Set<Participant> getParticipant() {
		return participant;
	}
	
	public void setReunion(Set<Reunion> reunion) {
		this.reunion = reunion;
	}
	
	public Set<Reunion> getReunion() {
		return reunion;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}
