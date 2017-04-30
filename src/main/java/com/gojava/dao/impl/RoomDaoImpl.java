package com.gojava.dao.impl;

import com.gojava.dao.RoomCrud;
import com.gojava.model.Room;
import com.gojava.model.User;

import java.util.LinkedHashSet;
import java.util.Set;

public class RoomDaoImpl implements RoomCrud<Room> {
	
	private Set<Room> repositoryRooms;
	private final String FILE_NAME = "rooms.db";

	public RoomDaoImpl() {
		repositoryRooms = new LinkedHashSet<>();
	}

	@Override
	public Room add(Room entity) {
		return null;
	}

	@Override
	public Room update(Room entity) {
		return null;
	}

	@Override
	public boolean delete(Room entity) {
		return false;
	}

	@Override
	public Set<Room> getAll() {
		return null;
	}

	@Override
	public boolean bookUser(Room aRoom, User user) {
		return false;
	}

	@Override
	public boolean unBookUser(Room aRoom) {
		return false;
	}
}
