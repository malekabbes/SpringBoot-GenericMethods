package tn.esprit.projectclass.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Equipe;
import tn.esprit.projectclass.services.Equipe.ImpServiceEq;

import java.util.List;

@RestController
@RequestMapping(value = "/equipe")
public class EquipeController {

    @Autowired
    private ImpServiceEq equipeservice;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Equipe save(@RequestBody Equipe eq) throws Exception {
        Equipe ContratResponse = (Equipe) equipeservice.save(eq);
        return ContratResponse;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Equipe> findAll() {
        try {
            return equipeservice.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteEquipe(@PathVariable int id) {
        try {
            equipeservice.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Equipe supprimé";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String UpdateEquipe(@RequestBody Equipe e,@PathVariable int id) {
        try {
            Equipe updateEquipe= equipeservice.retrieve(id);
            if (updateEquipe==null){
                return "Equipe not found with id :";
            }
            updateEquipe.setNomEquipe(e.getNomEquipe());
            updateEquipe.setNiveau(e.getNiveau());
            equipeservice.update(updateEquipe);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Equipe modifié ";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Equipe getEquipe(@PathVariable int id) throws Exception {
        Equipe equipeResponse = (Equipe) equipeservice.retrieve(id);
        return equipeResponse;
    }


}
