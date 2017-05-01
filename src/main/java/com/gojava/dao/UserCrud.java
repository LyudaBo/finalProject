package com.gojava.dao;

import com.gojava.model.Crud;
import com.gojava.model.Room;
import com.gojava.model.User;

/**
 *
 */
public interface UserCrud<T extends User> extends Crud<T> {

    boolean removeBookRoom(Room aRoom);
    boolean bookRoom(Room aRoom, User user);
}
