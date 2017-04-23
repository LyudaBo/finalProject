package com.gojava.dao.impl;

import com.gojava.dao.HotelDao;
import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.model.User;

public class HotelDaoImpl implements HotelDao {

    public Room findRoomByHotel(Hotel hotel) {
        return null;
    }

    public boolean bookRoom(Room room, User user) {
        return false;
    }

    public boolean removeBookRoom(Room room) {
        return false;
    }
}
