package com.gojava.controller.interactive;

import com.gojava.dao.impl.DataStorage;
import com.gojava.model.Interactive;
import com.gojava.service.FileManager;
import com.gojava.service.impl.FileManagerImpl;

import java.io.File;

import static com.gojava.dao.Utils.printBorder;
import static com.gojava.dao.Utils.provideIntInputStream;

public class InteractiveController implements Interactive{

    private final static String FILE_NAME = "file.txt";
    private HotelInteractive hotelInteractive = new HotelInteractive(this);
    private UserInteractive userInteractive = new UserInteractive(this);

    FileManager fileManager = new FileManagerImpl();


    @Override
    public void showMenu() {
        //TODO check why pops up exception stack trace
        initializeDataStorage();

        printBorder();
        System.out.println("1) Manage Hotels");
        System.out.println("2) Manage Rooms(not ready yet)");
        System.out.println("3) Manage Users");
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
                    //TODO make roomInteractive
                    showMenu();
                    break;
                case 3:
                    userInteractive.showMenu();
                    break;
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
