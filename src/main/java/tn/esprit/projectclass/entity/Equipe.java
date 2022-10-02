package tn.esprit.projectclass.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Equipe {
    @Id
    private int idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    @Column(name="Niveau")
    private Niveau niveau;
    @ManyToMany(mappedBy ="equipe")
    private Set<Etudiant> etudiant;

    public Set<Etudiant> getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Set<Etudiant> etudiant) {
        this.etudiant = etudiant;
    }

    public Equipe() {
    }

    public Equipe(int idEquipe, String nomEquipe, Niveau niveau) {
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
        this.niveau = niveau;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
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
}
