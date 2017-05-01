package com.gojava.controller.interactive;

import com.gojava.model.Crud;
import com.gojava.model.Interactive;
import com.gojava.model.User;
import com.gojava.service.impl.UserServiceImpl;

import java.util.Set;

import static com.gojava.dao.Utils.printBorder;
import static com.gojava.dao.Utils.provideIntInputStream;
import static com.gojava.dao.Utils.provideStringInputStream;

public class UsersMenu implements Interactive {

    private Interactive previousMenu;
    private Crud<User> userService = new UserServiceImpl();

    public UsersMenu(Interactive interactive) {
        this.previousMenu = interactive;
    }

    @Override
    public void showMenu() {
        printBorder();
        System.out.println("Users Menu");
        System.out.println("1) Add user");
        System.out.println("2) Update user");
        System.out.println("3) Delete user");
        System.out.println("4) Show all users");
        System.out.println("5) Back to main menu");
        printBorder();

        Integer selectedItem = provideIntInputStream();

        if (selectedItem == null) {
            System.err.println("not correct entered data, try again");
            previousMenu.showMenu();
        } else {
            switch (selectedItem) {
                case 1:
                    createUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    showAllUsers();
                    showMenu();
                    break;
                case 5:
                    previousMenu.showMenu();
                    break;
                default:
                    System.out.println("Incorrect input. Please try again");
                    showMenu();
            }
        }
    }


    private void createUser() {
        String name = provideStringInputStream("Enter your name: ");
        String lastName = provideStringInputStream("Enter your lastName: ");

        User user = new User(name, lastName);
        userService.create(user);
        System.out.println("user " + user + " added");
        showMenu();
    }

    private void showAllUsers() {
        System.out.println("Count of users: " + userService.getAll().values().size());
        userService.getAll().values().stream().forEach(System.out::println);
    }

    private void updateUser() {

        showAllUsers();
        Long usersId = enterUsersId();

        User userToUpdate = userService.getAll().get(usersId);


        if (userToUpdate == null) {
            System.out.println("User with this id has't been found");
            showMenu();
        } else {
            String newFirstName = provideStringInputStream("Enter new first name: ");
            String newLastName = provideStringInputStream("Enter new last name: ");
            userToUpdate.setFirstName(newFirstName);
            userToUpdate.setLastName(newLastName);
            System.out.println("This user with " + usersId + " changed");
        }
        showMenu();
    }

    private void deleteUser() {
        showAllUsers();

        Long idUser = enterUsersId();
        User userToDelete = userService.getAll().get(idUser);


        if (userToDelete == null) {
            System.out.println("User with this id has't been found");
            showMenu();
        } else {
            userService.delete(userToDelete);
        }
        showMenu();

    }

    private long enterUsersId() {
        Long idUser = null;

        String idUserString = provideStringInputStream("Enter id of user: ");
        if (idUserString == null) {
            showMenu();
        } else {
            idUser = Long.parseLong(idUserString);
        }
        return idUser;
    }
}
