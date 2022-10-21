package tn.esprit.projectclass.controllers.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.services.Etudiant.ImpServiceE;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class EtudiantController {

    @Autowired
    private ImpServiceE etudiantservice;

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
            etudiantservice.update(e);
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Etudiant has been updated successfully";
    }

}
