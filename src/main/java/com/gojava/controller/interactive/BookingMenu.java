package com.gojava.controller.interactive;

import com.gojava.dao.impl.DataStorage;
import com.gojava.model.Crud;
import com.gojava.model.Interactive;
import com.gojava.model.User;
import com.gojava.service.impl.UserServiceImpl;

import static com.gojava.dao.Utils.printBorder;
import static com.gojava.dao.Utils.provideIntInputStream;

/**
 *
 */
public class BookingMenu implements Interactive {

    private Interactive previousMenu;
    private Crud<User> userService = new UserServiceImpl();

    public BookingMenu(Interactive previousMenu) {
        this.previousMenu = previousMenu;
    }

    @Override
    public void showMenu() {
        printBorder();
        System.out.println("Booking  menu");
        System.out.println("1) Booking of room on users name");
        System.out.println("2) Un booking room");
        System.out.println("3) Back to main menu");
        printBorder();

        Integer selectedItem = provideIntInputStream();

        if (selectedItem == null) {
            System.err.println("not correct entered data, try again");
            showMenu();
        } else {
            switch (selectedItem) {
                case 1:
                    bookRoomOnUsersName();
                    break;
                case 2:
                   unBookingRoom();
                    break;
                case 3:
                    previousMenu.showMenu();
                    break;
                default:
                    showMenu();
                    break;
            }
        }
    }

    private void bookRoomOnUsersName() {
        //TODO do it
    }

    private void unBookingRoom() {
        //TODO do it
    }


}
