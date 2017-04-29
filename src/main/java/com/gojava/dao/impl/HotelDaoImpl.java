package com.gojava.dao.impl;

import com.gojava.dao.HotelCrud;
import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.model.User;

import java.util.Set;

public class HotelDaoImpl implements HotelCrud<Hotel> {

    @Override
    public Hotel add(Hotel hotel) {
        if (hotel == null) {
            throw new RuntimeException("Hotel can't be null");
        }
        if (DataStorage.getInstance().getHotels().contains(hotel)) {
           return DataStorage.getInstance().getHotels().stream().filter(v -> v.equals(hotel)).findFirst().get();
        } else {
            DataStorage.getInstance().getHotels().add(hotel);
            return hotel;
        }
    }

    @Override
    public Hotel update(Hotel hotel) {
        DataStorage.getInstance().getHotels().forEach(s -> {
          if (s.getId() == hotel.getId()){
              s.rewriteData(hotel);
            }
        });
        return hotel;
    }

    @Override
    public boolean delete(Hotel hotel) {
        return DataStorage.getInstance().getHotels().remove(hotel);
    }

    public boolean bookRoom(Room room, User user) {
        return false;
    }

    public boolean removeBookRoom(Room room) {
        return false;
    }

    @Override
    public Set<Hotel> getAll() {
        return DataStorage.getInstance().getHotels();
    }

}
