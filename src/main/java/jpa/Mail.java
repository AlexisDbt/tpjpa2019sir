package jpa;
import javax.persistence.*;

@Entity
@Table(name="Mail")
public class Mail {
	
	@OneToMany
	private Participant participant;
	@OneToMany
	private Reunion reunion;
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
		participant = new Participant();
		reunion = new Reunion();
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
	
	
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	
	public Participant getParticipant() {
		return participant;
	}
	
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	
	public Reunion getReunion() {
		return reunion;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}
