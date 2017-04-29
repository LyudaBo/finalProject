package com.gojava.dao.impl;

import com.gojava.model.Hotel;
import com.gojava.model.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DataStorage implements Serializable {

    private static DataStorage INSTANCE;

    private Set<Hotel> hotels = new HashSet<>();
    private Set<User> users = new HashSet<>();


    private DataStorage() {
    }

    public static DataStorage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataStorage();
        }
        return INSTANCE;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
