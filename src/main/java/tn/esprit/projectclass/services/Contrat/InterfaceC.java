package tn.esprit.projectclass.services.Contrat;

import tn.esprit.projectclass.Generic.InterfaceGeneric;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Universite;

public interface InterfaceC extends InterfaceGeneric<Contrat> {
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) throws Exception;
    Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE) throws Exception;

}
