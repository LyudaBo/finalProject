package com.gojava.dao;

import com.gojava.model.Hotel;
import com.gojava.model.Room;
import com.gojava.model.User;

public interface HotelDao {

    //Добавить отель
    //Редактировать данные отеля
    //Добавить комнату в отель


    //Удалить комнату из отеля

    //Удалить отель


    //Поиск отеля по имени
    //Поиск отеля по городу
    //Поиск комнаты по отелю
    Room findRoomByHotel(Hotel hotel);

    //Бронирование комнаты на имя пользователя
    boolean bookRoom(Room room, User user);

    //Отмена бронирования комнаты
    boolean removeBookRoom(Room room);
}
