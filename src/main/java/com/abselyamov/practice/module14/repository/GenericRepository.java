package com.abselyamov.practice.module14.repository;

import java.util.Set;

public interface GenericRepository<T, ID> {

    void add(T t);

    T getById(ID id);

    Set<T> getAll();

    void delete(T t);

}
