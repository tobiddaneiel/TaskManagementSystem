package com.example.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> allUsers = new ArrayList<>();

    public UserManager() {
        allUsers = new ArrayList<>();
    }

    public void register(User user) {
        if (user == null) {
            throw new NullPointerException("Go create a User before registering");
        }
        allUsers.add(user);
    }

    public boolean login(String username, String password) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return true;
            }
        }
        return false;  // Invalid login
    }

    public List<User> getAllUsers() {
        return allUsers;
    }
}
