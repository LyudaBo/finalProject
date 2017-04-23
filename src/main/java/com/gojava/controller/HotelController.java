package com.gojava.controller;

import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.service.HotelService;

public class HotelController {

    private HotelService hotelService;

    public Room findRoomByHotel(Hotel hotel) {
        return hotelService.findRoomByHotel(hotel);
    }
}
