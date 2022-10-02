package tn.esprit.projectclass.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idContrat;
    @Temporal(TemporalType.DATE)
private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
private Date dateFinContrat;
@Enumerated(EnumType.ORDINAL)
private Specialite specialite;

private boolean archive;
    @OneToOne
    private Etudiant etudiant;

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Contrat() {
    }

    public Contrat(int idContrat, Date dateDebutContrat, Date dateFinContrat, Specialite specialite, boolean archive) {
        this.idContrat = idContrat;
        this.dateDebutContrat = dateDebutContrat;
        this.dateFinContrat = dateFinContrat;
        this.specialite = specialite;
        this.archive = archive;
    }

    public int getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }

    public Date getDateDebutContrat() {
        return dateDebutContrat;
    }

    public void setDateDebutContrat(Date dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }

    public Date getDateFinContrat() {
        return dateFinContrat;
    }

    public void setDateFinContrat(Date dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }
}
