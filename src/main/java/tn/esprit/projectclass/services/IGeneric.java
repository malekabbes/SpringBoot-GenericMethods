package tn.esprit.projectclass.services;

import java.util.List;
public interface IGeneric<T>{
    List<T> findAll() throws Exception;
    T save(T entity) throws Exception;
    void delete(Long id) throws Exception;
}
