package tn.esprit.projectclass.services.Universite;

import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Option;
import tn.esprit.projectclass.entity.Universite;
import tn.esprit.projectclass.services.IGeneric;

public interface IntServiceU extends IGeneric<Universite> {
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
}
