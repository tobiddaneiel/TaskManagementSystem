package com.example.taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {
    private List<User> allUsers;

    public UserManager() {
        allUsers = new ArrayList<>();
    }

    public void register(User user) {
        if (user == null) {
            throw new NullPointerException("Go create a User before registering");
        }
        allUsers.add(user);
    }

    public User login(String username, String password) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                System.out.printf("User logged in successfully: %s%n", user.toString());
                return user;
            }
        }
        System.out.println("Invalid login");
        return null;  // Invalid login
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void saveAllUsersToFile() {
        PersistenceManager.saveUsers(allUsers);
    }

    public void loadAllUsersFromFile() {
        this.allUsers = PersistenceManager.loadUsers();
        }
}
