package tn.esprit.projectclass.repository;

import net.bytebuddy.description.type.TypeList;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projectclass.Generic.GenericRepository;
import tn.esprit.projectclass.entity.Contrat;

import java.io.Serializable;
import java.util.List;

public interface ContratRepository extends GenericRepository<Contrat> {
 List<Contrat> findContratByEtudiant_IdAndArchiveFalse(int id);
 int countByArchiveIsFalseAndEtudiantNomEAndEtudiantPrenomE(String nomE,String prenomE);
}