package com.gojava.dao;

import java.util.Set;

public interface RoomDao<T>{

    //Редактировать данные комнаты
	void add(T entity);
	void update(T entity);
	void delete(T entity);
	T find(long id);
	Set<T> all();
}
