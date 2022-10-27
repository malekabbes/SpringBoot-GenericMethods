package tn.esprit.projectclass.controllers.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Option;
import tn.esprit.projectclass.services.Contrat.ImpServiceC;
import tn.esprit.projectclass.services.Departement.ImpServiceD;
import tn.esprit.projectclass.services.Etudiant.ImpServiceE;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/student")
public class EtudiantController {

    @Autowired
    private ImpServiceE etudiantservice;
    @Autowired
    private ImpServiceC contratservice;
    @Autowired
    private ImpServiceD depservice;
    public Contrat res;
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody

    public List<Etudiant> findAll() {
        try {
            return etudiantservice.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Etudiant save(@RequestBody Etudiant etudiant) throws Exception {
        Etudiant studentResponse = (Etudiant) etudiantservice.save(etudiant);
        return studentResponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Etudiant getStudent(@PathVariable int id) throws Exception {
        Etudiant studentResponse = (Etudiant) etudiantservice.retrieve(id);
        return studentResponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteStudent(@PathVariable int id) {
        try {
            etudiantservice.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "student has been deleted successfully";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String UpdateEtudiant(@RequestBody Etudiant e,@PathVariable int id) {
        try {
            Etudiant updateduser= etudiantservice.retrieve(id);
            if (updateduser==null){
                return "User not found with id :";
            }
            updateduser.setNomE(e.getNomE());
            updateduser.setPrenomE(e.getPrenomE());
            etudiantservice.update(updateduser);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Etudiant has been updated successfully";
    }

    @RequestMapping(value = "/assign/{option}/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String AddAndAssign(@RequestBody Etudiant e,@PathVariable Option option,@PathVariable int id) {
        try {
            Departement dep = depservice.retrieve(id);

            if (dep!=null) {
              etudiantservice.addAndAssignEtudiant(e, option, dep);
            }
            else {
                return null;
            }
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "ADDED AND ASSIGNED USER ";
    }

    @RequestMapping(value = "/assigndep/{ide}/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String AssignDep(@PathVariable Integer ide,@PathVariable Integer id) {
        try {
         etudiantservice.assignEtudiantToDepartement(ide,id);
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "ADDED STUDENT AND ASSIGNED TO DEPARTMENT";
    }
    @RequestMapping(value="/assigneq/{idcontrat}/{idequipe}",method=RequestMethod.POST)
    @ResponseBody
    public String AssignEtudianttoEquipeandContrat(@RequestBody Etudiant e,@PathVariable int idcontrat,@PathVariable int idequipe){
        try {
            contratservice.addAndAssignEtudiantToEquipeAndContract(e,idcontrat,idequipe);
        if (contratservice.Studentcheck){
            return "Student exists already";
        }
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "STUDENT ADDED AND ASSIGNED TO EQUIPE AND CONTRAT";
    }

    @RequestMapping(value="/affectcontrat/{nomE}/{prenomE}",method=RequestMethod.POST)
    @ResponseBody
    public String affectContratToEtudiant(@RequestBody Contrat c, @PathVariable String nomE, @PathVariable String prenomE){

            if (contratservice.contratfull){
                return "Limite de contrats atteinte";
            } else{
                try {
                contratservice.affectContratToEtudiant(c, nomE, prenomE);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
            }
        return "Le contrat a été affecté a l'etudiant";
    }





}
