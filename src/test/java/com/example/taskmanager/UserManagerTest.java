package com.example.taskmanager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {
    private UserManager userManager;
    private User user1;
    private User user2;
    private final String username1 = "testUser1";
    private final String username2 = "testUser2";
    String password1 = "securePass123";
    String password2 = "securePass231";

    @BeforeEach
    public void setup(){
        userManager = new UserManager();
        user1 = new User(username1, password1);
        user2 = new User(username2, password2);
    }
    @AfterEach
    public void cleanup(){
        userManager = null;
        user1 = null;
        user2 = null;
    }
    @Test
    public void testRegisterAndGetAllUsers() {
        userManager.register(user1);
        userManager.register(user2);
        assertEquals(2, userManager.getAllUsers().size());
        assertTrue(userManager.getAllUsers().contains(user1));
        assertTrue(userManager.getAllUsers().contains(user2));
        assertEquals(userManager.getAllUsers().get(0).getUsername(), username1);
        assertEquals(userManager.getAllUsers().get(1).getUsername(), username2);
    }
    @Test
    public void testLogin(){
        userManager.register(user1);
        User loggedInUser1 = userManager.login(username1, password1);
        assertNotNull(loggedInUser1);
        User loggedInUser2 = userManager.login(username2, password2);
        assertNull(loggedInUser2);
        userManager.register(user2);
        User loggedInUser2Again = userManager.login(username2, password2);
        assertNotNull(loggedInUser2Again);
    }
    @Test
    public void testRegisterWithNullUser(){
        //userManager.register(null);
        assertThrows(NullPointerException.class, () -> userManager.register(null));
    }
}
