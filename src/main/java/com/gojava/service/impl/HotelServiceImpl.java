package com.gojava.service.impl;

import com.gojava.dao.HotelCrud;
import com.gojava.dao.impl.HotelDaoImpl;
import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.model.User;

import java.util.Set;

public class HotelServiceImpl implements HotelCrud<Hotel> {

    private HotelCrud<Hotel> hotelDao = new HotelDaoImpl();

    @Override
    public Hotel add(Hotel hotel) {
        return hotelDao.add(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        return hotelDao.update(hotel);
    }

    @Override
    public boolean delete(Hotel hotel) {
        return hotelDao.delete(hotel);
    }

    @Override
    public Set<Hotel> getAll() {
        return hotelDao.getAll();
    }

    @Override
    public boolean removeBookRoom(Room room) {
        return false;
    }

    @Override
	public boolean bookRoom(Room room, User user) {
		// TODO Auto-generated method stub
		return false;
	}
}
