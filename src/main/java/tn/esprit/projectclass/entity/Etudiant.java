package tn.esprit.projectclass.entity;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Etudiant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToOne
    private Departement department;
    @ManyToMany
    private Set<Equipe> equipe;
    @OneToOne(mappedBy = "etudiant")
    private Contrat contrat;
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

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public Etudiant() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

