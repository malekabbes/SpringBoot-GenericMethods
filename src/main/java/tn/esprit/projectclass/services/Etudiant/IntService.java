package tn.esprit.projectclass.services.Etudiant;

import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Option;

import java.util.List;
public interface IntService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant (Etudiant e);
    Etudiant addAndAssignEtudiant (Etudiant e, Option o, Departement d);
    Etudiant updateEtudiant (Etudiant e,Integer idEtudiant);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
}
