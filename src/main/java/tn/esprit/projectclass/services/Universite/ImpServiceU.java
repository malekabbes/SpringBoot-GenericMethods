package tn.esprit.projectclass.services.Universite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Option;
import tn.esprit.projectclass.entity.Universite;
import tn.esprit.projectclass.repository.EtudiantRepository;
import tn.esprit.projectclass.repository.UniversiteRepository;

import java.util.List;

@Service
public class ImpServiceU implements IntServiceU {
    @Autowired

    protected UniversiteRepository repo;


    @Override
    public List<Universite> findAll() throws Exception {
        try {
            return repo.findAll();
        } catch (Exception e) {
            System.out.println("Une erreur survenue" + e);
        }
        return null;
    }

    @Override
    public Universite save(Universite u) throws Exception {
        try {
            return repo.save(u);
        } catch (Exception e) {
            System.out.println("Un erreur survenue : "+e);
        }
        return u;
    }

    @Override
    public void delete(int id) throws Exception {
        repo.deleteById(id);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        try {
            Universite univ=repo.findById(u.getIdUniv()).get();
            try {
                return repo.save(univ);
            } catch (Exception err1) {
                System.out.println("Un erreur survenue"+err1);
            }
        } catch (Exception err2) {
            System.out.println("Universite non trouvé : "+err2);
        }
        return null;
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        Universite u=repo.findById(idUniversite).get();
        try{
            return u;
        } catch(Exception err) {
            System.out.println("Un erreur survenue" + err);
        }
        return u;
    }
}
