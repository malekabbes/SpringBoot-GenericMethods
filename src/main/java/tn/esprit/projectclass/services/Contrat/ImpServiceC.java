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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ImpServiceC extends ImplementationGeneric<Contrat> implements InterfaceC {
    @Autowired
    EtudiantRepository repo;
    @Autowired
    GenericRepository<Departement> deprepo;
    @Autowired
    ContratRepository crepo;
    @Autowired
    GenericRepository<Equipe> eqrepo;
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
        // Etudiant etudiant = findByNomAndPrenom(nomE,prenomE);
        Etudiant etudiant=repo.findEtudiantByNomEAndPrenomE(nomE,prenomE);
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
    public List<Contrat> ContratsValides(Date startDate, Date endDate){
          List<Contrat> list = crepo.findAll();
          ArrayList<Contrat> contratvalides=new ArrayList<Contrat>();
        for (Contrat c : list){
            Date datedebut=c.getDateDebutContrat();
            Date datefin=c.getDateFinContrat();
            if (startDate.after(datedebut) && endDate.before(datefin) && !c.isArchive()){
                contratvalides.add(c);
            }
        }
        return contratvalides;
    }
    public Integer nbContratsValides(Date startDate, Date endDate){
        List<Contrat> list = crepo.findAll();
        int nbContratvalides=0;
        for (Contrat c : list){
            Date datedebut=c.getDateDebutContrat();
            Date datefin=c.getDateFinContrat();
            if (startDate.after(datedebut) && endDate.before(datefin) && !c.isArchive()){
                nbContratvalides++;
            }
        }
        return nbContratvalides;
    }
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate){
        List<Contrat> list=ContratsValides(startDate,endDate);
        System.out.println(list);
        float montant=0;
        for (Contrat c: list){
            if(c.getSpecialite().name().equals("IA")){
               montant+=300;
            } else if(c.getSpecialite().name().equals("RESEAUX")){
                montant+=350;
            } else if(c.getSpecialite().name().equals("CLOUD")){
                montant+=400;
            } else if(c.getSpecialite().name().equals("SECURITE")){
                montant+=450;
            } else {
                montant+=0;
            }
        }
        System.out.println(montant);
        return montant;
    }
}
