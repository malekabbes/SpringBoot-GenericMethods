package tn.esprit.projectclass.services.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projectclass.Generic.GenericRepository;
import tn.esprit.projectclass.Generic.ImplementationGeneric;
import tn.esprit.projectclass.entity.*;
import tn.esprit.projectclass.repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

public class ImpServiceE extends ImplementationGeneric<Etudiant,Integer> implements InterfaceE{
    @Autowired
    EtudiantRepository repo;
    @Autowired
    GenericRepository<Departement,Integer> deprepo;

    @Autowired
    GenericRepository<Equipe,Integer> eqrepo;
    @Autowired
    GenericRepository<Contrat,Integer> crepo;
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
    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement){
       List<Etudiant> depetudiants=repo.findEtudiantByDepartment_Id(idDepartement);
       return depetudiants;
    }
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe){
        try {
            Contrat contrat=crepo.findById(idContrat).orElse(null);
            Equipe equipe=eqrepo.findById(idEquipe).orElse(null);
            Etudiant etudiant= new Etudiant();
            if (contrat !=null && equipe !=null){
                etudiant=repo.save(e);
                etudiant.setEquipe(Collections.singleton(equipe));
                contrat.setEtudiant(etudiant);
                return etudiant;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return e;
    }





}
