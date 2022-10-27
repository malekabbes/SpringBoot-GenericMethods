package tn.esprit.projectclass.controllers.Etudiant;

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




}
