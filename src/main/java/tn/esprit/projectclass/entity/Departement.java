package tn.esprit.projectclass.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Departement {
    @Id
    private int idDepart;
    private String nomDepart;


    @OneToMany(mappedBy = "department")
    private Set<Etudiant> etudiant;
    public Departement() {
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
