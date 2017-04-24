package com.gojava.dao.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.gojava.dao.RoomDao;
import com.gojava.model.Room;

public class RoomDaoImpl implements RoomDao<Room> {
	
	private List<Room> repositiryRooms;
	private final String FILE_NAME = "rooms.db";
	
	

	public RoomDaoImpl() {
		repositiryRooms = new LinkedList<>();
	}

	@Override
	public void add(Room entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Room entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Room entity) {
		// TODO Auto-
		
	}

	@Override
	public Room find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Room> all() {
		
		return null;
	}
	
	
}
