package com.gojava;

import com.gojava.controller.interactive.InteractiveController;
import com.gojava.model.Interactive;

public class Main {
    public static void main(String[] args) {
        try {
            Interactive interactiveController = new InteractiveController();
            interactiveController.showMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
