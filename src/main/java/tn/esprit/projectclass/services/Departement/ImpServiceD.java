package tn.esprit.projectclass.services.Departement;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projectclass.Generic.GenericRepository;
import tn.esprit.projectclass.Generic.ImplementationGeneric;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Universite;
import tn.esprit.projectclass.repository.DepartementRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ImpServiceD extends ImplementationGeneric<Departement,Integer> implements InterfaceD {
    @Autowired
    GenericRepository<Universite,Integer> repo;
    @Autowired
    GenericRepository<Departement,Integer> repodep;

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        try {
            Universite unv = repo.findById(idUniversite).orElse(null);
            Departement dep = repodep.findById(idDepartement).orElse(null);
            if (unv!=null && dep !=null){
                unv.setDepartment(dep);
                repo.save(unv);
            }

        } catch (Exception err) {
            System.out.println(err);

        }
    }
    @Override
    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Set<Departement> listdep= repo.findById(idUniversite).get().getDepartment();
        return listdep;
    }
}
