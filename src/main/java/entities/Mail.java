package entities;
import entities.Participant;
import entities.Reunion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Mail")
public class Mail {

	private List<Participant> participant = new ArrayList<Participant>();
	private List<Reunion> reunion = new ArrayList<Reunion>();
	private String lienPause;
	private String code;
	private String lienPad;
	@Id
	@GeneratedValue
	private Long id;
	
	public Mail() {
		
	}
	
	public Mail(String lienPause, String code, String lienPad) {
		this.code = code;
		this.lienPad = lienPad;
		this.lienPause = lienPause;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLienPad() {
		return lienPad;
	}

	public void setLienPad(String lienPad) {
		this.lienPad = lienPad;
	}

	public String getLienPause() {
		return lienPause;
	}

	public void setLienPause(String lienPause) {
		this.lienPause = lienPause;
	}

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "mail", fetch = FetchType.LAZY)
	public List<Participant> getParticipant() {
		return participant;
	}

	public void setParticipant(List<Participant> participant) {
		this.participant = participant;
	}

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "mail", fetch = FetchType.LAZY)
	public List<Reunion> getReunion() {
		return reunion;
	}

	public void setReunion(List<Reunion> reunion) {
		this.reunion = reunion;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}
