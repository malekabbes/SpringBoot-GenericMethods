package tn.esprit.projectclass.services.Contrat;

import tn.esprit.projectclass.Generic.InterfaceGeneric;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Universite;
import java.util.Date;
import java.util.List;
public interface InterfaceC extends InterfaceGeneric<Contrat,Integer> {
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) throws Exception;
    Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE) throws Exception;
    public Integer nbContratsValides(Date startDate, Date endDate) ;
    public List<Contrat> ContratsValides(Date startDate, Date endDate) ;

    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);


}
