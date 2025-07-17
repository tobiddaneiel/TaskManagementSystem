package com.example.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> allUsers = new ArrayList<>();

    public UserManager() {
        allUsers = new ArrayList<>();
    }

    public User register(String username, String password) {
        User user = new User(username, password);
        allUsers.add(user);
        return user;
    }

    public User login(String username, String password) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;  // Invalid login
    }

    public List<User> getAllUsers() {
        return allUsers;
    }
}
