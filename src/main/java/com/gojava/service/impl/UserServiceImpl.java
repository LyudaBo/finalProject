package com.gojava.service.impl;

import com.gojava.dao.impl.UserDaoImpl;
import com.gojava.model.Crud;
import com.gojava.model.User;

import java.util.Set;

public class UserServiceImpl implements Crud<User> {

    Crud<User> userDaoImpl = new UserDaoImpl();

    @Override
    public User add(User entity) {
        return userDaoImpl.add(entity);
    }

    @Override
    public User update(User entity) {
        return userDaoImpl.update(entity);
    }

    @Override
    public boolean delete(User entity) {
       return userDaoImpl.delete(entity);
    }

    @Override
    public Set<User> getAll() {
        return userDaoImpl.getAll();
    }
}
