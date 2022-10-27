package tn.esprit.projectclass.services.Universite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projectclass.Generic.GenericRepository;
import tn.esprit.projectclass.Generic.ImplementationGeneric;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Option;
import tn.esprit.projectclass.entity.Universite;
import tn.esprit.projectclass.repository.EtudiantRepository;
import tn.esprit.projectclass.repository.UniversiteRepository;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ImpServiceU extends ImplementationGeneric<Universite> implements InterfaceU {
    @Autowired
    GenericRepository<Universite> repo;
    @Autowired
    GenericRepository<Departement> repodep;
    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        try{
            Universite unv=repo.findById(idDepartement).orElse(null);
            Departement dep=repodep.findById(idUniversite).orElse(null);
            if (unv!=null){
              unv.setDepartment(Collections.singleton(dep));
              repo.save(unv);
            }
        }catch(Exception err){
            System.out.println("NULL FOUND");

        }
    }
}
