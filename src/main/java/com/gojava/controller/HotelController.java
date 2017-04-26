package com.gojava.controller;

import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.service.HotelService;
import com.gojava.service.impl.HotelServiceImpl;

import java.util.List;
import java.util.Set;

public class HotelController {

    private HotelService hotelService = new HotelServiceImpl();

    public Room findRoomByHotel(Hotel hotel) {
        return hotelService.findRoomByHotel(hotel);
    }

    public Hotel addHotel(Hotel hotel){
        return hotelService.addHotel(hotel);
    };

    public Hotel editHotel(Hotel hotel){
        return hotelService.editHotel(hotel);
    };

    public boolean deleteHotel(Hotel hotel){
        return hotelService.deleteHotel(hotel);
    };

    public Set<Hotel> getHotels() {
        return hotelService.listHotels();
    }
}
