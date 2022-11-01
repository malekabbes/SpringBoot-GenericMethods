package tn.esprit.projectclass.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Equipe  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    @Column(name="Niveau")
    private Niveau niveau;
    @ManyToMany(mappedBy ="equipe")
    @JsonIgnore
    private Set<Etudiant> etudiant;

    @OneToOne
    private DetailEquipe detailEquipe;

    public Set<Etudiant> getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Set<Etudiant> etudiant) {
        this.etudiant = etudiant;
    }

    public Equipe() {
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
