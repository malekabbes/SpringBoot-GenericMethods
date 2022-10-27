package tn.esprit.projectclass.services.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projectclass.Generic.GenericRepository;
import tn.esprit.projectclass.Generic.ImplementationGeneric;
import tn.esprit.projectclass.entity.*;
import tn.esprit.projectclass.repository.ContratRepository;
import tn.esprit.projectclass.repository.EtudiantRepository;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service

public class ImpServiceE extends ImplementationGeneric<Etudiant> implements InterfaceE{
    @Autowired
    EtudiantRepository repo;
    @Autowired
    GenericRepository<Departement> deprepo;

    @Autowired
    GenericRepository<Equipe> eqrepo;

    public boolean contratfull=false;
    @Override
    public void addAndAssignEtudiant(Etudiant e, Option o, Departement d) {
        try{
            e.setOption(o);
            e.setDepartment(d);
            repo.save(e);
        }catch (Exception err){
            System.out.println("Un erreur survenue : "+err);
        }
    }
    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        /*recuperation des objet*/
        Etudiant etudiant = repo.findById(etudiantId).orElse(null);
        Departement  departement = deprepo.findById(departementId).orElse(null);
        if (etudiant!=null && departement!=null){
            etudiant.setDepartment(departement);
            repo.save(etudiant);
        }
        else{
            System.out.println("NULL FOUND");
        }
    }






}
