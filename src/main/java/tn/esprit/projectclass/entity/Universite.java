package tn.esprit.projectclass.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Universite {
   @Id
    private int idUniv;
    private String nomUniv;
    @OneToMany
    private Set<Departement> department;

    public Universite() {
    }

    public int getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(int idUniv) {
        this.idUniv = idUniv;
    }

    public String getNomUniv() {
        return nomUniv;
    }

    public void setNomUniv(String nomUniv) {
        this.nomUniv = nomUniv;
    }
}
