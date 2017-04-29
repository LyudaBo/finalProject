package com.gojava.model;

import java.util.Set;

public interface Crud<T> {

    T add(T entity);
    T update(T entity);
    boolean delete(T entity);
    Set<T> getAll();
}
