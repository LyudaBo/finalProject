package com.gojava.dao.impl;

import com.gojava.dao.RoomCrud;
import com.gojava.model.Room;
import com.gojava.model.User;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class RoomDaoImpl implements RoomCrud<Room> {
	

	@Override
	public Room create(Room entity) {
		return null;
	}

	@Override
	public Room update(Room entity) {
		return null;
	}

	@Override
	public Room delete(Room entity) {
		return entity;
	}

	@Override
	public Map<Long, Room> getAll() {
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
