package com.gojava.dao.impl;

import com.gojava.dao.HotelDao;
import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.model.User;

import java.util.HashSet;
import java.util.Set;

public class HotelDaoImpl implements HotelDao {

    private Set<Hotel> hotels = new HashSet<>();

    @Override
    public Hotel addHotel(Hotel hotel) {
        if (hotel == null) {
            throw new RuntimeException("Hotel can't be null");
        }
        if (hotels.contains(hotel)) {
           return hotels.stream().filter(v -> v.equals(hotel)).findFirst().get();
        } else {
            hotels.add(hotel);
            return hotel;
        }
    }

    @Override
    public Hotel editHotel(Hotel hotel) {
        hotels.forEach(s -> {
          if (s.getId() == hotel.getId()){
              s.rewriteData(hotel);
            }
        });
        return hotel;
    }

    @Override
    public boolean deleteHotel(Hotel hotel) {
        return hotels.remove(hotel);
    }

    public Room findRoomByHotel(Hotel hotel) {
        return null;
    }

    public boolean bookRoom(Room room, User user) {
        return false;
    }

    public boolean removeBookRoom(Room room) {
        return false;
    }

    @Override
    public Set<Hotel> listHotels() {
        return hotels;
    }
}
