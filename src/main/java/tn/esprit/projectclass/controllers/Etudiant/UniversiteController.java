package tn.esprit.projectclass.controllers.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Universite;
import tn.esprit.projectclass.services.Universite.ImpServiceU;

@RestController
@RequestMapping(value = "/universite")
public class UniversiteController {
    @Autowired
    private ImpServiceU serviceunv;
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

    @RequestMapping(value = "/assign/{id}/{iddep}", method = RequestMethod.PUT )
    @ResponseBody
    public String AssignDep(@PathVariable Integer iddep,@PathVariable Integer id){
        try {
            serviceunv.assignUniversiteToDepartement(id,iddep);
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
