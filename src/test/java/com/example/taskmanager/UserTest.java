package com.example.taskmanager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    @BeforeEach
    public void setup(){
        user = new User("testUser", "<PASSWORD>");
    }

    @AfterEach
    public void cleanup(){
        user = null;
    }

    @Test
    public void testUserConstructor(){
        assertEquals("testUser", user.getUsername());
        assertNotNull(user.getId());
        assertThrows(IllegalArgumentException.class, () -> {new User(null, "password");});
        assertThrows(IllegalArgumentException.class, () -> {new User("username", null);});
        assertThrows(IllegalArgumentException.class, () -> {new User("", "password");});
        assertThrows(IllegalArgumentException.class, () -> {new User("username", "");});
    }

    @Test
    public void testSetAndGetUsername(){
        user.setUsername("newUsername");
        assertEquals("newUsername", user.getUsername());
    }
    @Test
    public void testSetAndCheckPassword(){
        user.setPassword("<PASSWORD>");
        assertTrue(user.checkPassword("<PASSWORD>"));
        assertThrows(IllegalArgumentException.class, () -> {user.setPassword(null);});
        assertThrows(IllegalArgumentException.class, () -> {user.setPassword("");});
        assertThrows(IllegalArgumentException.class, () -> {user.setPassword("<PASS");});
        assertThrows(IllegalArgumentException.class, () -> {user.setPassword(null);});
    }
    @Test
    public void testGetId(){
        assertNotNull(user.getId());
    }
    @Test
    public void testToString(){
        String result = user.toString();
        assertTrue(result.contains("User id:"));
        assertTrue(result.contains("Username: testUser"));
    }
}
