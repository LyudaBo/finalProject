package com.gojava.service.impl;

import com.gojava.dao.HotelDao;
import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.model.User;
import com.gojava.service.HotelService;

public class HotelServiceImpl implements HotelService {

    private HotelDao hotelDao;

    @Override
    public Room findRoomByHotel(Hotel hotel) {
        return hotelDao.findRoomByHotel(hotel);
    }

	@Override
	public boolean bookRoom(Room room, User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
