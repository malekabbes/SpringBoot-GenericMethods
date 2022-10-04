package tn.esprit.projectclass.services.Equipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Equipe;
import tn.esprit.projectclass.repository.DepartementRepository;
import tn.esprit.projectclass.repository.EquipeRepository;

import java.util.List;

@Service
public class ImpServiceEq implements IntServiceEq {
    @Autowired

    protected EquipeRepository repo;


    @Override
    public Equipe updateEquipe(Equipe e) {
        try {
            Equipe eq=repo.findById(e.getIdEquipe()).get();
            try {
                return repo.save(eq);
            } catch (Exception err1) {
                System.out.println("Un erreur survenue"+err1);
            }
        } catch (Exception err2) {
            System.out.println("Equipe non trouvé : "+err2);
        }
        return e;
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        Equipe eq=repo.findById(idEquipe).get();
        try{
            return eq;
        } catch(Exception err) {
            System.out.println("Un erreur survenue" + err);
        }
        return eq;
    }


    @Override
    public List<Equipe> findAll() throws Exception {
        try {
            return repo.findAll();
        } catch (Exception err) {
            System.out.println("Un erreur survenue"+ err);
        }
        return null;
    }

    @Override
    public Equipe save(Equipe eq) throws Exception {
        try {
            return repo.save(eq);
        } catch (Exception err) {
            System.out.println("Un erreur survenue : " + err);
        }
        return eq;
    }

    @Override
    public void delete(int id) throws Exception {
        repo.deleteById(id);
    }
}
