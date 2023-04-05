package com.simraninovation.bankingApi.service;

import java.util.Set;

public interface  CrudService<T, ID> {
    Set<T> findAll();

    T findById(ID id);
    // Object can be anything
    T save(T object);

    void delete();
    void deleteById(ID id);
}
