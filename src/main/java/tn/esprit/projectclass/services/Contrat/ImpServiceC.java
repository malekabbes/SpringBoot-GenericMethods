package tn.esprit.projectclass.services.Contrat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.repository.ContratRepository;

import java.util.List;

@Service
public class ImpServiceC implements IntServiceC {
    @Autowired

    protected ContratRepository repo;


    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        Contrat c=repo.findById(idContrat).get();
        try{
            return c;
        } catch(Exception err) {
            System.out.println("Un erreur survenue" + err);
        }
        return c;
        }

    @Override
    public Contrat updateContrat(Contrat ce) {
        try {
            Contrat contrat=repo.findById(ce.getIdContrat()).get();
            try {
                return repo.save(contrat);
            } catch (Exception err1) {
                System.out.println("Un erreur survenue"+err1);
            }
        } catch (Exception err2) {
            System.out.println("Contrat non trouvé : "+err2);
        }
        return ce;
    }


    @Override
    public List<Contrat> findAll() throws Exception {
        try {
            return (List<Contrat>) repo.findAll();
        } catch (Exception err) {
            System.out.println("Un erreur survenue"+ err);
        }
        return null;
    }

    @Override
    public Contrat save(Contrat ce) throws Exception {
        try {
            return repo.save(ce);
        } catch (Exception err) {
            System.out.println("Un erreur survenue : " + err);
        }
        return ce;
    }

    @Override
    public void delete(Long id) throws Exception {
        repo.deleteById(id);
    }
}
