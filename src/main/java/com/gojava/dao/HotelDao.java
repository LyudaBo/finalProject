package com.gojava.dao;

import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.model.User;

public interface HotelDao {

    //Добавить отель
    Hotel addHotel(Hotel hotel);

    //Редактировать данные отеля
    Hotel editHotel(Hotel hotel);

    //Удалить отель
    boolean deleteHotel(Hotel hotel);

    //Добавить комнату в отель
    //Удалить комнату из отеля
    //Поиск отеля по имени
    //Поиск отеля по городу


    //Поиск комнаты по отелю
    Room findRoomByHotel(Hotel hotel);

    //Бронирование комнаты на имя пользователя
    boolean bookRoom(Room room, User user);

    //Отмена бронирования комнаты
    boolean removeBookRoom(Room room);
}
