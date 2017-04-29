package com.gojava.dao.impl;

import com.gojava.model.Crud;
import com.gojava.model.User;

import java.util.Set;

public class UserDaoImpl implements Crud<User> {

    @Override
    public User add(User entity) {
        DataStorage.getInstance().getUsers().add(entity);
        return entity;
    }

    @Override
    public User update(User entity) {
        //todo fixed
        return null;
    }

    @Override
    public boolean delete(User entity) {
        return DataStorage.getInstance().getUsers().remove(entity);
    }

    @Override
    public Set<User> getAll() {
        return DataStorage.getInstance().getUsers();
    }
}
