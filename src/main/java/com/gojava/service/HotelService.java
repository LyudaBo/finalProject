package com.gojava.service;

import com.gojava.model.Hotel;
import com.gojava.model.Room;

public interface HotelService {
    Room findRoomByHotel(Hotel hotel);
}
