package com.gojava.dao.impl;

import com.gojava.dao.AbstractDao;
import com.gojava.model.User;


public class UserDaoImpl extends AbstractDao<User> {


    public UserDaoImpl(String file_name) {
        super(file_name);
    }
}
