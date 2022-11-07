package tn.esprit.projectclass.services.Contrat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
        if (etudiant!=null) {
            //List<Contrat> list = crepo.findContratByEtudiant_IdAAndArchiveFalse(etudiant.getId());
            int nbrcontrat=crepo.countByArchiveIsFalseAndEtudiantNomEAndEtudiantPrenomE(nomE,prenomE);
            if (nbrcontrat>=5){
                contratfull=true;
            }
        }
// nbContratsValides = etudiant.getContrat().stream().
        // .filter(contrat -> !contrat.isArchive())
        //
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
    @Scheduled(fixedRate = 3000)
    public String retrieveAndUpdateStatusContrat() throws Exception {
        List<Contrat> contrats = this.findAll();
        List<String> contratsValides = new ArrayList<>();
        List<String> contratfini = new ArrayList<>();
        String contrat = "";
        String contratInfo = "" ;
        for (Contrat c : contrats) {
            try {
                Date datefin = c.getDateFinContrat();
                Date today = java.sql.Date.valueOf(java.time.LocalDate.now());
                contratInfo = "Contrat [ " +"\n" +" ContratId :" + c.getId() + " \n" +
                        " dateFin : "+ datefin + " \n"+ " Etudiant : " +c.getEtudiant().getNomE() + " " +
                        "  " +c.getEtudiant().getPrenomE() + "\n"+" Specialite : " + c.getSpecialite() + " ] ";
                if (c.isArchive()) {
                    if (datefin.getTime() - today.getTime() > 15) {
                        contratsValides.add(contratInfo);
                        contrat = contrat.concat("List de Contrat a revoir " + contratsValides.toString()+"\n");
                    }
                }
                boolean b = datefin.compareTo(today) == 0 && LocalDateTime.now().getHour() == 13;

                if (b) {
                    contratfini.add(contratInfo);
                    contrat = contrat.concat("List de Contrat fini"+contratfini.toString());
                    c = this.retrieve(c.getId());
                    c.setArchive(true);
                    this.update(c);
                }
            } catch (NullPointerException e) {
                e.getCause();
                // System.out.println("null");
            }
        }
        Thread.sleep(2000);
        System.out.println(contrat);
        return  contrat;
    }
}
