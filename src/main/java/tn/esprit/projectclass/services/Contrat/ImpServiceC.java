package tn.esprit.projectclass.services.Contrat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projectclass.Generic.GenericRepository;
import tn.esprit.projectclass.Generic.ImplementationGeneric;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Equipe;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.repository.ContratRepository;
import tn.esprit.projectclass.repository.EtudiantRepository;
import tn.esprit.projectclass.services.Etudiant.InterfaceE;

import java.util.Collections;
import java.util.List;

@Service
public class ImpServiceC extends ImplementationGeneric<Contrat,Integer> implements InterfaceC {
    @Autowired
    EtudiantRepository repo;
    @Autowired
    GenericRepository<Departement,Integer> deprepo;
    @Autowired
    ContratRepository crepo;
    @Autowired
    GenericRepository<Equipe,Integer> eqrepo;
    public boolean Studentcheck;
    public boolean contratfull=false;

    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe){
        try {
            Contrat contrat=crepo.findById(idContrat).orElse(null);
            Equipe equipe=eqrepo.findById(idEquipe).orElse(null);
            try {
                Studentcheck=repo.existsByprenomE(e.getPrenomE());
                System.out.println("Studentcheck = " + Studentcheck);
                if (!Studentcheck){
                    e.setEquipe(Collections.singleton(equipe));
                    contrat.setEtudiant(e);
                    repo.save(e);
                }
            } catch (Exception ex) {
                throw new RuntimeException("Student exists already",ex);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return e;
    }
    public Etudiant findByNomAndPrenom(String nomE, String prenomE) {
        List<Etudiant> list = repo.findAll();
        Etudiant e=new Etudiant();
        for (Etudiant et:list){
            if(et.getNomE().equals(nomE) && et.getPrenomE().equals(prenomE)){
                e=et;
                return e;
            }
        }
        return e;
    }
    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) throws Exception {
        Etudiant etudiant = findByNomAndPrenom(nomE,prenomE);
        List<Contrat> list= crepo.findContratByEtudiant_Id(etudiant.getId());
        if (list.size()>=5){
            contratfull=true;
        }
        if (!contratfull){
            ce.setEtudiant(etudiant);
            crepo.save(ce);

        }
        return ce;

    }
}
