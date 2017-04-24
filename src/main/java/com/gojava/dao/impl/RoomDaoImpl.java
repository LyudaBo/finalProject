package com.gojava.dao.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import com.gojava.dao.RoomDao;
import com.gojava.dao.UtilsFile;
import com.gojava.model.Room;

public class RoomDaoImpl implements RoomDao<Room> {
	
	private Set<Room> repositoryRooms;
	private final String FILE_NAME = "rooms.db";

	public RoomDaoImpl() {
		repositoryRooms = new LinkedHashSet<>();
	}

	@Override
	public void add(Room entity) {
		repositoryRooms = getAll();
		repositoryRooms.add(entity);
		UtilsFile.writeFile(FILE_NAME, repositoryRooms);
	}

	@Override
	public void update(Room entity) {
		repositoryRooms = getAll();
		Room room = findById(entity.getId());
		repositoryRooms.remove(room);
		repositoryRooms.add(entity);
		UtilsFile.writeFile(FILE_NAME, repositoryRooms);
	}

	@Override
	public void delete(Room entity) {
		entity.setDelete(true);
		update(entity);
		UtilsFile.writeFile(FILE_NAME, repositoryRooms);
	}

	@Override
	public Room findById(long id) {
		Optional<Room> room1 = getAll().stream().filter(room -> room.getId() == id ).findFirst();
		return room1.get();
	}

	@Override
	public Set<Room> getAll() {
		repositoryRooms = UtilsFile.readFile(FILE_NAME);
		return repositoryRooms;
	}
	
	
}
