package com.gojava.controller.interactive;

import com.gojava.dao.impl.DataStorage;
import com.gojava.model.Interactive;
import com.gojava.service.FileManager;
import com.gojava.service.impl.FileManagerImpl;

import static com.gojava.dao.Utils.printBorder;
import static com.gojava.dao.Utils.provideIntInputStream;

public class MainMenu implements Interactive{

    private final static String FILE_NAME = "file.txt";
    private HotelsMenu hotelInteractive = new HotelsMenu(this);
    private UsersMenu usersMenu = new UsersMenu(this);
    private BookingMenu bookingMenu = new BookingMenu(this);

    FileManager fileManager = new FileManagerImpl();


    @Override
    public void showMenu() {
        //TODO check why pops up exception stack trace
        initializeDataStorage();

        printBorder();
        System.out.println("Main Menu");
        System.out.println("1) Hotels menu");
        System.out.println("2) Users Menu");
        System.out.println("3) Booking menu");
        System.out.println("4) Exit" );
        printBorder();

        Integer selectedItem = provideIntInputStream();

        if (selectedItem == null) {
            System.err.println("not correct entered data, try again");
            showMenu();
        } else {
            switch (selectedItem) {
                case 1:
                    hotelInteractive.showMenu();
                    break;
                case 2:
                    usersMenu.showMenu();
                    break;
                case 3:
                    bookingMenu.showMenu();
                case 4:
                    fileManager.writeData(DataStorage.getInstance(), FILE_NAME);
                    System.exit(0);
                    break;
                default:
                    showMenu();
                    break;
            }
        }
    }

    private void initializeDataStorage() {
        DataStorage storage = fileManager.readData(FILE_NAME);
        if (storage == null) {
            DataStorage.getInstance();
        } else {
            DataStorage.getInstance().setHotels(storage.getHotels());
            DataStorage.getInstance().setUsers(storage.getUsers());
        }
    }
}
