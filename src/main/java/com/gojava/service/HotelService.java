package com.gojava.service;

import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.model.User;

public interface HotelService {
    Room findRoomByHotel(Hotel hotel);
    boolean bookRoom(Room room, User user);
}
