package com.gojava.controller.interactive;

import com.gojava.dao.HotelCrud;
import com.gojava.model.Hotel;
import com.gojava.model.Interactive;
import com.gojava.service.impl.HotelServiceImpl;

import static com.gojava.dao.Utils.printBorder;
import static com.gojava.dao.Utils.provideIntInputStream;

/**
 *
 */
public class HotelMenu implements Interactive {

    private Hotel currentHotel;
    private Interactive previousMenu;
    private HotelCrud<Hotel> hotelController = new HotelServiceImpl();

    public HotelMenu(Hotel currentHotel, Interactive previousMenu) {
        this.currentHotel = currentHotel;
        this.previousMenu = previousMenu;
    }

    @Override
    public void showMenu() {
        printBorder();
        System.out.println("Hotel " + currentHotel + " menu");
        System.out.println("1) Add room to hotel");
        System.out.println("2) Update room");
        System.out.println("3) Delete room");
        System.out.println("4) Show all rooms");
        System.out.println("5) back to hotels menu");
        printBorder();

        Integer selectedItem = provideIntInputStream();

        if (selectedItem == null) {
            System.err.println("not correct entered data, try again");
            showMenu();
        } else {
            switch (selectedItem) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    updateRoom();
                    break;
                case 3:
                    deleteRoom();
                    break;
                case 4:
                    showAllRooms();
                    break;
                case 5:
                    previousMenu.showMenu();
                    break;
                default:
                    showMenu();
                    break;
            }
        }

    }

    private void addRoom() {
        //TODO do it
    }

    private void updateRoom() {
        //TODO do it
    }

    private void deleteRoom() {
        //TODO do it
    }

    private void showAllRooms() {
        //TODO do it
    }

}
