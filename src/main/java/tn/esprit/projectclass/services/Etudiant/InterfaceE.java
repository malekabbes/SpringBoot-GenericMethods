package tn.esprit.projectclass.services.Etudiant;

import tn.esprit.projectclass.Generic.InterfaceGeneric;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Option;

import java.util.List;

public interface InterfaceE extends InterfaceGeneric<Etudiant,Integer> {
    void addAndAssignEtudiant(Etudiant e, Option o, Departement d) throws Exception;
     void assignEtudiantToDepartement(Integer etudiantid,Integer departementId) throws Exception;
     List<Etudiant> getEtudiantsByDepartement (Integer idDepartement) throws Exception;
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) throws Exception;
}
