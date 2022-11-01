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
public class ImpServiceU extends ImplementationGeneric<Universite,Integer> implements InterfaceU {
    @Autowired
    GenericRepository<Universite,Integer> repo;
    @Autowired
    GenericRepository<Departement,Integer> repodep;

}
