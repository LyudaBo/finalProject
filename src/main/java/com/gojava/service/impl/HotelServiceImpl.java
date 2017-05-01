package com.gojava.service.impl;

import com.gojava.dao.HotelCrud;
import com.gojava.dao.impl.HotelDaoImpl;
import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.model.User;

import java.util.Map;
import java.util.Set;

public class HotelServiceImpl implements HotelCrud<Hotel> {

    private HotelCrud<Hotel> hotelDao = new HotelDaoImpl();

    @Override
    public Hotel create(Hotel hotel) {
        return hotelDao.create(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        return hotelDao.update(hotel);
    }

    @Override
    public Hotel delete(Hotel hotel) {
        return hotelDao.delete(hotel);
    }

    @Override
    public Map<Long, Hotel> getAll() {
        hotelDao.getAll();
        return null;
    }
}
