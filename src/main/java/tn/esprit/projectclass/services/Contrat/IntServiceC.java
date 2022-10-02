package tn.esprit.projectclass.services.Contrat;

import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.services.IGeneric;

public interface IntServiceC extends IGeneric<Contrat> {

    Contrat retrieveContrat (Integer idContrat);
    Contrat updateContrat (Contrat ce);
}
