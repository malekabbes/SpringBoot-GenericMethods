package tn.esprit.projectclass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.services.Contrat.ImpServiceC;

import java.util.List;
@RestController
@RequestMapping(value = "/contrat")
public class ContratController {
    @Autowired
    private ImpServiceC contratservice;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Contrat save(@RequestBody Contrat con) throws Exception {
        Contrat ContratResponse = (Contrat) contratservice.save(con);
        return ContratResponse;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Contrat> findAll() {
        try {
            return contratservice.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteContrat(@PathVariable int id) {
        try {
            contratservice.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "contrat supprimé";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String UpdateContrat(@RequestBody Contrat e,@PathVariable int id) {
        try {
            Contrat updateContrat= contratservice.retrieve(id);
            if (updateContrat==null){
                return "Contrat not found with id :";
            }
            updateContrat.setDateFinContrat(e.getDateFinContrat());
            updateContrat.setArchive(e.getArchive());
            contratservice.update(updateContrat);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Contrat modifié ";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Contrat getContrat(@PathVariable int id) throws Exception {
        Contrat ContratResponse = (Contrat) contratservice.retrieve(id);
        return ContratResponse;
    }

}
