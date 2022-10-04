package tn.esprit.projectclass.services.Departement;

import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.services.IGeneric;

import java.util.List;

public interface IntServiceD extends IGeneric<Departement> {

    Departement updateDepartement(Departement d);
    Departement retrieveDepartement(int idDepart);
}
