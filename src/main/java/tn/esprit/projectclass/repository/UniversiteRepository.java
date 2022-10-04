package tn.esprit.projectclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projectclass.entity.Universite;

import java.io.Serializable;

public interface UniversiteRepository extends JpaRepository<Universite, Serializable> {
}