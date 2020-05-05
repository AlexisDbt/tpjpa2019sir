package entities;

import javax.persistence.*;

@Entity
public class ReponseSondage {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Sondage sondage;

    public ReponseSondage (Participant participant, Sondage sondage) {
        this.nom = participant.getNom();
        this.prenom = participant.getPrenom();
        this.email = participant.getEmail();
        this.sondage = sondage;
    }

    public ReponseSondage(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Sondage getSondage() {
        return sondage;
    }

    public void setSondage(Sondage sondage) {
        this.sondage = sondage;
    }
}
