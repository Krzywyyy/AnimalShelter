package pl.krzywyyy.animalshelter.services;

import java.util.List;

public interface AbstractService<T, ID> {
    T save(T obj);

    T findById(ID id);

    List<T> findAll();

    boolean delete(ID id);
}
