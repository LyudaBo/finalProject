package com.gojava.service;

import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.model.User;

import java.util.Set;

public interface HotelService {

    Hotel addHotel(Hotel hotel);

    Hotel editHotel(Hotel hotel);

    boolean deleteHotel(Hotel hotel);

    Room findRoomByHotel(Hotel hotel);

    boolean bookRoom(Room room, User user);

    Set<Hotel> listHotels();
}
