package tn.esprit.projectclass.controllers.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.services.Contrat.IntServiceC;

public class ContratController {
    @Autowired
    private IntServiceC contratservice;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Contrat save(@RequestBody Contrat con) throws Exception {
        Contrat ContratResponse = (Contrat) contratservice.save(con);
        return ContratResponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Contrat getContrat(@PathVariable int id) {
        Contrat ContratResponse = (Contrat) contratservice.retrieveContrat(id);
        return ContratResponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteContrat(@PathVariable int id) {
        try {
            contratservice.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Contrat has been deleted successfully";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    @ResponseBody
    public String UpdateContrat(@RequestBody Contrat con) {
        try {
            contratservice.updateContrat(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Contrat has been updated successfully";
    }

}
