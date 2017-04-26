package com.gojava.controller.interactive;

import com.gojava.model.Interactive;

import static com.gojava.dao.Utils.printBorder;
import static com.gojava.dao.Utils.provideIntInputStream;

public class InteractiveController implements Interactive{

    private HotelInteractive hotelInteractive = new HotelInteractive(this);

    @Override
    public void showMenu() {
        printBorder();
        System.out.println("1) Manage Hotels(works only this)");
        System.out.println("2) Manage Rooms");
        System.out.println("3) Manage Users");
        printBorder();

        Integer selectedItem = provideIntInputStream();

        if (selectedItem != null && selectedItem == 1) {
            hotelInteractive.showMenu();
        } else {
            System.err.println("not ready yet");
            showMenu();
        }
    }
}
