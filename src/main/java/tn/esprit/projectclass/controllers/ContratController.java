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
    public Contrat save(@RequestBody Contrat con) throws Exception {
        Contrat ContratResponse = (Contrat) contratservice.save(con);
        return ContratResponse;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Contrat> findAll() {
        try {
            return contratservice.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteContrat(@PathVariable int id) {
        try {
            contratservice.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "contrat supprimé";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String UpdateContrat(@RequestBody Contrat e,@PathVariable int id) {
        try {
            Contrat updateContrat= contratservice.retrieve(id);
            if (updateContrat==null){
                return "Contrat not found with id :";
            }
            updateContrat.setDateFinContrat(e.getDateFinContrat());
            updateContrat.setArchive(e.getArchive());
            updateContrat.setSpecialite(e.getSpecialite());
            contratservice.update(updateContrat);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Contrat modifié ";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Contrat getContrat(@PathVariable int id) throws Exception {
        Contrat ContratResponse = (Contrat) contratservice.retrieve(id);
        return ContratResponse;
    }

    @RequestMapping(value = "/chiffreaffaire", method = RequestMethod.GET)
    public float GetChiffreAffaire(@RequestBody Contrat e ) throws Exception {
        float chiffreaffaire = contratservice.getChiffreAffaireEntreDeuxDate(e.getDateDebutContrat(),e.getDateFinContrat());
        return chiffreaffaire;
    }
    @RequestMapping(value = "/statuscontrat", method = RequestMethod.GET)
    public String retrieveAndUpdateStatusContrat() throws Exception {
        return contratservice.retrieveAndUpdateStatusContrat();
    }


}
