package tn.esprit.projectclass.entity;

import javax.persistence.*;

@Entity
public class DetailEquipe{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int salle;
    private String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalle() {
        return salle;
    }

    public void setSalle(int salle) {
        this.salle = salle;
    }

    public String getThematique() {
        return thematique;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }
}
