package tn.esprit.projectclass.services.Equipe;

import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Equipe;
import tn.esprit.projectclass.services.IGeneric;

public interface IntServiceEq extends IGeneric<Equipe> {
    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);

}
