package tn.esprit.projectclass.services.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projectclass.Generic.GenericRepository;
import tn.esprit.projectclass.Generic.ImplementationGeneric;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Option;
import tn.esprit.projectclass.repository.EtudiantRepository;

import java.util.List;

@Service

public class ImpServiceE extends ImplementationGeneric<Etudiant> implements InterfaceE{

   GenericRepository<Etudiant> repo;
    @Override
    public Etudiant addAndAssignEtudiant(Etudiant e, Option o, Departement d) {
        try{
            e.setOption(o);
            e.setDepartment(d);
            return repo.save(e);
        }catch (Exception err){
            System.out.println("Un erreur survenue : "+err);
        }
        return null;
    }
}
