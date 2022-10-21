package tn.esprit.projectclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.projectclass.Generic.GenericRepository;
import tn.esprit.projectclass.entity.Contrat;
import tn.esprit.projectclass.entity.Departement;

import java.io.Serializable;

public interface DepartementRepository extends GenericRepository<Departement> {

}