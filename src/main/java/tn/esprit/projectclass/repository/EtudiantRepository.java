package tn.esprit.projectclass.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Option;

import java.util.List;

public interface EtudiantRepository extends CrudRepository<Etudiant, Object> {

}