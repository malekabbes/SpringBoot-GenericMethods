package tn.esprit.projectclass.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectclass.entity.DetailEquipe;
import tn.esprit.projectclass.entity.Equipe;
import tn.esprit.projectclass.services.DetailEquipe.ImpServiceDetail;
import java.util.List;
@RestController
@RequestMapping(value = "/deteq")
public class DetailEquipeController {

    @Autowired
    private ImpServiceDetail Detailservice;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public DetailEquipe save(@RequestBody DetailEquipe deq) throws Exception {
        DetailEquipe DetailResponse = (DetailEquipe) Detailservice.save(deq);
        return DetailResponse;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<DetailEquipe> findAll() {
        try {
            return Detailservice.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteDetailEquipe(@PathVariable int id) {
        try {
            Detailservice.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Detail Equipe supprimé";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String UpdateDetailEquipe(@RequestBody DetailEquipe e,@PathVariable int id) {
        try {
            DetailEquipe updateDEquipe= Detailservice.retrieve(id);
            if (updateDEquipe==null){
                return "Detail Equipe not found with id :";
            }
            updateDEquipe.setSalle(e.getSalle());
            updateDEquipe.setThematique(e.getThematique());
            Detailservice.update(updateDEquipe);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Detail Equipe modifié ";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DetailEquipe getDEquipe(@PathVariable int id) throws Exception {
        DetailEquipe DequipeResponse = (DetailEquipe) Detailservice.retrieve(id);
        return DequipeResponse;
    }

}
