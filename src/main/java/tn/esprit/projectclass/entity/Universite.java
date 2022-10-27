package tn.esprit.projectclass.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Universite  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomUniv;
    @OneToMany
    private Set<Departement> department;

    public Universite() {
    }

    public int getId() {
        return id;
    }

    public Set<Departement> getDepartment() {
        return department;
    }

    public void setDepartment(Departement department) {
        this.department.add(department);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomUniv() {
        return nomUniv;
    }

    public void setNomUniv(String nomUniv) {
        this.nomUniv = nomUniv;
    }
}
