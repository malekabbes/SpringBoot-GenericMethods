package tn.esprit.projectclass.services.Etudiant;

import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Option;
import tn.esprit.projectclass.services.IGeneric;

public interface IntServiceE extends IGeneric<Etudiant> {
    public Etudiant addAndAssignEtudiant(Etudiant e, Option o, Departement d);
    public Etudiant updateEtudiant(Etudiant e,Integer id);
    public Etudiant retrieveEtudiant(int idEtudiant);
}
