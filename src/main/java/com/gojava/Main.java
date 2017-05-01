package com.gojava;

import com.gojava.controller.interactive.MainMenu;
import com.gojava.model.Interactive;

public class Main {
    public static void main(String[] args) {
        try {
            Interactive mainMenu = new MainMenu();
            mainMenu.showMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
