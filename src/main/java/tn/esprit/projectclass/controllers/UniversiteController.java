package tn.esprit.projectclass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Universite;
import tn.esprit.projectclass.services.Departement.ImpServiceD;
import tn.esprit.projectclass.services.Universite.ImpServiceU;

@RestController
@RequestMapping(value = "/universite")
public class UniversiteController {
    @Autowired
    private ImpServiceU serviceunv;
    @Autowired
    private ImpServiceD servicedp;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Universite save(@RequestBody Universite con) throws Exception {
        Universite UniversiteResponse = (Universite) serviceunv.save(con);
        return UniversiteResponse;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String UpdateUniversite(@RequestBody Universite u, @PathVariable int id) {
        try {
            Universite updatedunv = serviceunv.retrieve(id);
            if (updatedunv == null) {
                return "Universite not found with id :" + id;
            }
            updatedunv.setNomUniv(u.getNomUniv());
            serviceunv.update(updatedunv);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "University has been updated successfully";
    }

    @RequestMapping(value = "/assign/{id}/{iddep}", method = RequestMethod.POST )
    @ResponseBody
    public String AssignDep(@PathVariable int id,@PathVariable int iddep){
        try {
            servicedp.assignUniversiteToDepartement(id,iddep);
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "ASSIGNED UNIVERSITE TO DEPARTMENT";
    }
    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    @ResponseBody
    private String deleteUniversite(@PathVariable("id") int id) {
        try {
            serviceunv.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Universite ha sbeen deleted successfully";
    }





}
