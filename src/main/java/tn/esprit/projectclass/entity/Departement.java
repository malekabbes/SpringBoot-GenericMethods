package tn.esprit.projectclass.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Departement{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomDepart;

    public Set<Etudiant> getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Set<Etudiant> etudiant) {
        this.etudiant = etudiant;
    }

    @OneToMany(mappedBy = "department")
    @JsonIgnore
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
