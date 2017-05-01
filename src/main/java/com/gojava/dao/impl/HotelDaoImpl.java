package com.gojava.dao.impl;

import com.gojava.dao.HotelCrud;
import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.model.User;

import java.util.Map;
import java.util.Set;

public class HotelDaoImpl implements HotelCrud<Hotel> {

    @Override
    public Hotel create(Hotel hotel) {

        if (hotel == null) {
            throw new RuntimeException("Hotel can't be null");
        } else {
        DataStorage.getInstance().getHotels().put(hotel.getId(), hotel);

        return hotel;
        }
    }

    @Override
    public Hotel update(Hotel hotel) {
        //TODO remake it
        DataStorage.getInstance().getHotels().put(hotel.getId(), hotel);
        return hotel;
    }

    @Override
    public Hotel delete(Hotel hotel) {
       return DataStorage.getInstance().getHotels().remove(hotel.getId());
    }

    @Override
    public Map<Long, Hotel> getAll() {
        return DataStorage.getInstance().getHotels();
    }

}
