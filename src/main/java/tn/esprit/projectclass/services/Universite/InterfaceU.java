package tn.esprit.projectclass.services.Universite;

import tn.esprit.projectclass.Generic.InterfaceGeneric;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Universite;

public interface InterfaceU extends InterfaceGeneric<Universite> {
    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
