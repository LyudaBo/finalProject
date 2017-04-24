package com.gojava.dao;

import java.util.Set;

/**
 * Created by root on 23.04.2017.
 */
public interface DAO<T> {

    void add(T entity);
    void update(T entity);
    void delete(T entity);
    T findById(long id);
    Set<T> getAll();

}
