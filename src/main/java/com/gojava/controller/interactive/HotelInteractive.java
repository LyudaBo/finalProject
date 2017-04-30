package com.gojava.controller.interactive;

import com.gojava.dao.HotelCrud;
import com.gojava.model.Hotel;
import com.gojava.model.IdGenerator;
import com.gojava.model.Interactive;
import com.gojava.model.Room;
import com.gojava.service.impl.HotelServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static com.gojava.dao.Utils.*;

public class HotelInteractive implements Interactive {

    private Interactive interactive;
    private HotelCrud<Hotel> hotelController = new HotelServiceImpl();

    public HotelInteractive(Interactive interactive) {
        this.interactive = interactive;
    }

    @Override
    public void showMenu() {
        printBorder();
        System.out.println("1) create hotel");
        System.out.println("2) edit hotel");
        System.out.println("3) delete hotel");
        System.out.println("4) list hotels");
        System.out.println("5) back to main menu");
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
                    editHotel();
                    break;
                case 3:
                    deleteHotel();
                    break;
                case 4:
                    listHotels();
                    break;
                case 5:
                    interactive.showMenu();
                    break;
                default:
                    showMenu();
                    break;
            }
        }
    }

    private void backToMainMenu() {
        interactive.showMenu();
    }

    public void addHotel() {
        String name = provideStringInputStream("enter hotel name: ");
        String city = provideStringInputStream("enter hotel city: ");
        Set<Room> aRooms = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            aRooms.add(new Room());
        }

        Hotel hotel = new Hotel(
                IdGenerator.getRandomId(),
                name,
                aRooms,
                city
        );

        Hotel addedHotel = hotelController.add(hotel);
        System.out.println("added new hotel: " + addedHotel.toString());

        backToMainMenu();
    }

    public void editHotel() {
        System.err.println("not ready yet");
        backToMainMenu();
    }

    public void deleteHotel() {
        System.err.println("not ready yet");
        backToMainMenu();
    }

    public void listHotels() {
        Set<Hotel> hotels = hotelController.getAll();

        if (hotels.isEmpty()) {
            System.out.println("no hotels");
        } else {
            for (Hotel hotel : hotelController.getAll()) {
                System.out.println("hotel: " + hotel.toString());
            }
        }

        backToMainMenu();
    }
}
