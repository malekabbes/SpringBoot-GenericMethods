package tn.esprit.projectclass.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;


@Entity

public class Etudiant  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToOne(cascade =CascadeType.PERSIST)
    @JsonIgnore
    private Departement department;
    @ManyToMany
    private Set<Equipe> equipe;
    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore

    private Set<Contrat> contrat;
    public Departement getDepartment() {
        return department;
    }

    public void setDepartment(Departement department) {
        this.department = department;
    }

    public Set<Equipe> getEquipe() {
        return equipe;
    }

    public void setEquipe(Set<Equipe> equipe) {
        this.equipe = equipe;
    }

    public Set<Contrat> getContrat() {
        return contrat;
    }

    public void setContrat(Set<Contrat> contrat) {
        this.contrat = contrat;
    }

    public Etudiant() {

    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

