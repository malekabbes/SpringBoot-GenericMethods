package tn.esprit.projectclass.Generic;

import java.util.List;
public interface InterfaceGeneric<T>{
    List<T> findAll() throws Exception;
    T save(T entity) throws Exception;
    void delete(int id) throws Exception;
    T retrieve(int id) throws Exception;
    T update (T entity) throws Exception;


}
