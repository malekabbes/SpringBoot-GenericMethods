package tn.esprit.projectclass.entity;

import javax.persistence.*;

@Entity
public class Departement {
    @Id
    private int idDepart;
    private String nomDepart;
    @ManyToOne
    private Universite universite;
    public Departement() {
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public Departement(int idDepart, String nomDepart) {
        this.idDepart = idDepart;
        this.nomDepart = nomDepart;
    }

    public int getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
    }
}
