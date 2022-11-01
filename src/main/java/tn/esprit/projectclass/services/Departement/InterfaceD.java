package tn.esprit.projectclass.services.Departement;

import tn.esprit.projectclass.Generic.InterfaceGeneric;
import tn.esprit.projectclass.entity.Departement;

import java.util.List;
import java.util.Set;

public interface InterfaceD extends InterfaceGeneric<Departement,Integer>{
    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
