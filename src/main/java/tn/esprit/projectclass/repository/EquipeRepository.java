package tn.esprit.projectclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.projectclass.Generic.GenericRepository;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Equipe;

import java.io.Serializable;

public interface EquipeRepository extends GenericRepository<Equipe> {
}