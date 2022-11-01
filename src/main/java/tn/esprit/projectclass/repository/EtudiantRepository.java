package tn.esprit.projectclass.repository;

import tn.esprit.projectclass.Generic.GenericRepository;
import tn.esprit.projectclass.entity.Etudiant;

import java.util.List;

public interface EtudiantRepository extends GenericRepository<Etudiant> {
    Boolean existsByprenomE(String name);
    List<Etudiant> findEtudiantByDepartment_Id(Integer idDepartement);
    Etudiant findEtudiantByNomEAndPrenomE(String nomE,String prenomE);
}