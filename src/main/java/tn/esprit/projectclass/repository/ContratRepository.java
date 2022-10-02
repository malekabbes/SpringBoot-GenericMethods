package tn.esprit.projectclass.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.projectclass.entity.Contrat;

import java.io.Serializable;

public interface ContratRepository extends CrudRepository<Contrat, Serializable> {
}