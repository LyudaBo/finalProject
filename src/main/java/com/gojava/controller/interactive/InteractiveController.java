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
        DataStorage storage = fileManager.readData(FILE_NAME);
        if (storage == null) {
            DataStorage.getInstance();
        } else {
            DataStorage.getInstance().setHotels(storage.getHotels());
            DataStorage.getInstance().setUsers(storage.getUsers());
        }

        printBorder();
        System.out.println("1) Manage Hotels(works only this)");
        System.out.println("2) Manage Rooms");
        System.out.println("3) Manage Users");
        System.out.println("4) Exit" );
        printBorder();

        Integer selectedItem = provideIntInputStream();

        if (selectedItem != null && selectedItem == 1) {
            hotelInteractive.showMenu();
        } else if (selectedItem == 3) {
            userInteractive.showMenu();
        }else if(selectedItem == 4){
            fileManager.writeData(DataStorage.getInstance(), FILE_NAME);
            System.exit(0);
        } else {
            System.err.println("not ready yet");
            showMenu();
        }
    }
}
