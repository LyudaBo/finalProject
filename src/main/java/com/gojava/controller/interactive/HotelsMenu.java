package com.gojava.controller.interactive;

import com.gojava.dao.HotelCrud;
import com.gojava.model.Hotel;
import com.gojava.model.Interactive;
import com.gojava.model.Room;
import com.gojava.service.impl.HotelServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static com.gojava.dao.Utils.*;

public class HotelsMenu implements Interactive {

    private Interactive previousMenu;
    private HotelMenu hotelMenu;
    private HotelCrud<Hotel> hotelController = new HotelServiceImpl();

    public HotelsMenu(Interactive interactive) {
        this.previousMenu = interactive;
    }

    @Override
    public void showMenu() {
        printBorder();
        System.out.println("Users menu");
        System.out.println("1) Add hotel");
        System.out.println("2) Update hotel");
        System.out.println("3) Delete hotel");
        System.out.println("4) Show all hotels");
        System.out.println("5) Manage hotel rooms");
        System.out.println("6) Back to main menu");
        printBorder();

        Integer selectedItem = provideIntInputStream();

        if (selectedItem == null) {
            System.err.println("not correct entered data, try again");
            showMenu();
        } else {
            switch (selectedItem) {
                case 1:
                    addHotel();
                    break;
                case 2:
                    updateHotel();
                    break;
                case 3:
                    deleteHotel();
                    break;
                case 4:
                    showAllHotels();
                    break;
                case 5:
                    manageHotelRooms();
                    break;
                case 6:
                    previousMenu.showMenu();
                    break;
                default:
                    showMenu();
                    break;
            }
        }
    }


    public void addHotel() {
        //TODO remake it
        String name = provideStringInputStream("enter hotel name: ");
        String city = provideStringInputStream("enter hotel city: ");
        Set<Room> aRooms = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            aRooms.add(new Room(name));
        }

        Hotel hotel = new Hotel(
                name,
                city
        );

        Hotel addedHotel = hotelController.create(hotel);
        System.out.println("added new hotel: " + addedHotel.toString());

        showMenu();
    }

    public void updateHotel() {
        //TODO make it
        System.err.println("not ready yet");
        showMenu();
    }

    public void deleteHotel() {
        //TODO make it
        System.err.println("not ready yet");
        showMenu();
    }

    public void showAllHotels() {
        //TODO remake
//        Set<Hotel> hotels = hotelController.getAll();
//
//        if (hotels.isEmpty()) {
//            System.out.println("no hotels");
//        } else {
//            for (Hotel hotel : hotelController.getAll()) {
//                System.out.println("hotel: " + hotel.toString());
//            }
//        }
        showMenu();
    }

    private void manageHotelRooms() {
        System.out.print("Enter hotels id: ");
        Integer selectedItem = provideIntInputStream();

        Hotel hotel = null; //TODO find this hotel


        hotelMenu = new HotelMenu(hotel, this);
        hotelMenu.showMenu();
    }
}
