package com.gojava.controller.interactive;

import com.gojava.model.Crud;
import com.gojava.model.Interactive;
import com.gojava.model.User;
import com.gojava.service.impl.UserServiceImpl;

import java.util.Set;

import static com.gojava.dao.Utils.printBorder;
import static com.gojava.dao.Utils.provideIntInputStream;
import static com.gojava.dao.Utils.provideStringInputStream;

public class UserInteractive implements Interactive {
    private Interactive interactive;
    private Crud<User> userService = new UserServiceImpl();

    public UserInteractive(Interactive interactive) {
        this.interactive = interactive;
    }

    @Override
    public void showMenu() {
        printBorder();
        System.out.println("1) create user");
        System.out.println("2) update user");
        System.out.println("3) delete user");
        System.out.println("4) list users");
        System.out.println("5) back to main menu");
        printBorder();

        Integer selectedItem = provideIntInputStream();

        if (selectedItem == null) {
            System.err.println("not correct entered data, try again");
            interactive.showMenu();
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
                    break;
                case 5:
                    backToMainMenu();
                    break;
                default:
                    showMenu();

            }
        }
    }
    private void backToMainMenu() {
        interactive.showMenu();
    }

    private void createUser () {
        String name = provideStringInputStream("Enter your name: ");
        String lastName = provideStringInputStream("Enter your lastName: ");

        User user = new User(name, lastName);
        userService.add(user);
        System.out.println("user added");
        showMenu();
    }

    private void showAllUsers(){
        Set<User> users = userService.getAll();
        System.out.println("count: "+users.size());
        users.forEach(System.out::println);
        showMenu();
    }

    private void updateUser () {
        showAllUsers();

        Long finalIdUser = enterUsersId();
        User userToUpdate = userService.getAll()
                .stream()
                .filter(user -> finalIdUser.equals(user.getId()))
                .findFirst()
                .get();

        if (userToUpdate == null){
            System.out.println("User with this id has't been found");
            showMenu();
        } else {
            String newFirstName = provideStringInputStream("Enter new first name: ");
            String newLastName = provideStringInputStream("Enter new last name: ");
            userToUpdate.setFirstName(newFirstName);
            userToUpdate.setLastName(newLastName);
            System.out.println("This user with " + finalIdUser + " changed");
        }
        showMenu();
    }

    private void deleteUser(){
        showAllUsers();

        Long finalIdUser = enterUsersId();
        User userToDelete = userService.getAll()
                .stream()
                .filter(user -> finalIdUser.equals(user.getId()))
                .findFirst()
                .get();

        if (userToDelete == null){
            System.out.println("User with this id has't been found");
            showMenu();
        } else {
            userService.delete(userToDelete);
        }
        showMenu();

    }

    private long enterUsersId(){
        Long idUser = null;

        String idUserString = provideStringInputStream("Enter id of user: ");
        if (idUserString == null){
            showMenu();
        }else {
            idUser = Long.parseLong(idUserString);
        }
        return idUser;
    }
}
