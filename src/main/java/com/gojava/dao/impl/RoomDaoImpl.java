package com.gojava.dao.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import com.gojava.dao.RoomDao;
import com.gojava.dao.UtilsFile;
import com.gojava.model.Room;

public class RoomDaoImpl implements RoomDao<Room> {
	
	private Set<Room> repositiryRooms;
	private final String FILE_NAME = "rooms.db";

	public RoomDaoImpl() {
		repositiryRooms = new LinkedHashSet<>();
	}

	@Override
	public void add(Room entity) {
		repositiryRooms = all();
		repositiryRooms.add(entity);
		UtilsFile.writeFiule(FILE_NAME, repositiryRooms);
	}

	@Override
	public void update(Room entity) {
		repositiryRooms = all();
		Room room = find(entity.getId());
		repositiryRooms.remove(room);
		repositiryRooms.add(entity);
		UtilsFile.writeFiule(FILE_NAME, repositiryRooms);
	}

	@Override
	public void delete(Room entity) {
		entity.setDelete(true);
		update(entity);
		UtilsFile.writeFiule(FILE_NAME, repositiryRooms);
	}

	@Override
	public Room find(long id) {
		Optional<Room> room1 = all().stream().filter(room -> room.getId() == id ).findFirst();
		return room1.get();
	}

	@Override
	public Set<Room> all() {
		repositiryRooms = UtilsFile.readFiule(FILE_NAME);
		return repositiryRooms;
	}
	
	
}
