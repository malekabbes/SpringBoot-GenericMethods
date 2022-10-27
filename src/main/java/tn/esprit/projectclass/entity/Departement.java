package tn.esprit.projectclass.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Departement{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomDepart;



    @OneToMany(mappedBy = "department")
    private Set<Etudiant> etudiant;


    public Departement() {
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
    }
}
