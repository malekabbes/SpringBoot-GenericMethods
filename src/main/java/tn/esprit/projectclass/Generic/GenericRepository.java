package tn.esprit.projectclass.Generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
@NoRepositoryBean
public interface GenericRepository<T,ID> extends JpaRepository<T, ID> {

}
