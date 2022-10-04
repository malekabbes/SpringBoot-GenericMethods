package tn.esprit.projectclass.services.Departement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.repository.DepartementRepository;

import java.util.List;

@Service
public class ImpServiceD implements IntServiceD {
    @Autowired

    protected DepartementRepository repo;

    @Override
    public Departement updateDepartement(Departement d) {
        try {
            Departement dep=repo.findById(d.getIdDepart()).get();
            try {
                return repo.save(dep);
            } catch (Exception err1) {
                System.out.println("Un erreur survenue"+err1);
            }
        } catch (Exception err2) {
            System.out.println("Contrat non trouvé : "+err2);
        }
        return d;
    }

    @Override
    public Departement retrieveDepartement(int idDepart) {
        Departement d=repo.findById(idDepart).get();
        try{
            return d;
        } catch(Exception err) {
            System.out.println("Un erreur survenue" + err);
        }
        return d;
    }

    @Override
    public List<Departement> findAll() throws Exception {
        try {
            return repo.findAll();
        } catch (Exception e) {
            System.out.println("Une erreur survenue" + e);
        }
        return null;
    }

    @Override
    public Departement save(Departement d) throws Exception {
        try {
            return repo.save(d);
        } catch (Exception e) {
            System.out.println("Un erreur survenue : "+e);
        }
        return d;
    }


    @Override
    public void delete(int id) throws Exception {
         repo.deleteById(id);
    }
}
