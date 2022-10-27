package tn.esprit.projectclass.controllers.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Universite;
import tn.esprit.projectclass.services.Contrat.ImpServiceC;
import tn.esprit.projectclass.services.Departement.ImpServiceD;
import tn.esprit.projectclass.services.Etudiant.ImpServiceE;

import java.util.List;

@RestController
@RequestMapping(value = "/Departement")
public class DepartementController {
    @Autowired
    private ImpServiceE etudiantservice;
    @Autowired
    private ImpServiceC contratservice;
    @Autowired
    private ImpServiceD depservice;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Departement> findAll() {
        try {
            return depservice.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Departement save(@RequestBody Departement departement) throws Exception {
        Departement departementresponse = (Departement) depservice.save(departement);
        return departementresponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteDepartement(@PathVariable int id) {
        try {
            depservice.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Departement has been deleted successfully";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Departement getDepartement(@PathVariable int id) throws Exception {
        Departement DepartementResponse = (Departement) depservice.retrieve(id);
        return DepartementResponse;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String UpdateDepartement(@RequestBody Departement d,@PathVariable int id) {
        try {
            Departement updateddep= depservice.retrieve(id);
            if (updateddep==null){
                return "Departement not found with id :";
            }
            updateddep.setNomDepart(d.getNomDepart());
            depservice.update(updateddep);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Departement has been updated successfully";
    }


}
