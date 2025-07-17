package com.example.taskmanager;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TaskPersistenceTest {

    private final String tempFilePath = "temp_file.json";

    @BeforeEach
    public void setup() {
        TaskPersistenceManager.setTaskFilePath(tempFilePath);
        TaskPersistenceManager.setUserFilePath(tempFilePath);
    }
    @AfterEach
    public void cleanup() {
        new File(tempFilePath).delete();
    }

    @Test
    public void testSaveAndLoadTasks() {
        Task task1 = new Task("Sample Task", "Description");
        Task task2 = new Task("Sample Task 2", "Description 2");
        Map<Integer, List<Task>> userTaskDictionary = Map.of(1, List.of(task1, task2));
        TaskPersistenceManager.saveTasks(userTaskDictionary);
        Map<Integer, List<Task>> loadedTaskDictionary = TaskPersistenceManager.loadTasks();
        assertEquals(userTaskDictionary.size(), loadedTaskDictionary.size());
        assertEquals(userTaskDictionary.get(1).get(0).getTitle(), loadedTaskDictionary.get(1).get(0).getTitle());

    }
    @Test
    public void testLoadTasksReturnsEmptyWhenFileDoesNotExist(){
        Map<Integer, List<Task>> loadedTaskDictionary = TaskPersistenceManager.loadTasks();
        assertTrue(loadedTaskDictionary.isEmpty());
    }

    @Test
    public void testLoadTasksFromCorruptedJsonFile() {
        // Arrange: create a corrupted JSON file
        File corruptedFile = new File("temp_file_2.json");
        TaskPersistenceManager.setTaskFilePath("temp_file_2.json");

        try (var writer = new java.io.FileWriter(corruptedFile)) {
            writer.write("{ invalid json: ["); // Malformed JSON
        } catch (Exception e) {
            fail("Failed to set up corrupted file for test.");
        }

        // Act: attempt to load the corrupted file
        Map<Integer, List<Task>> result = TaskPersistenceManager.loadTasks();

        // Assert: should return an empty map and not throw
       assertTrue(result.isEmpty(), "Expected empty map on corrupted JSON input.");
       new File("temp_file_2.json").delete();
    }
    @Test
    public void testSaveAndLoadUsers() {
        User user1 = new User("User1", "securePass123");
        User user2 = new User("User2", "securePass231");
        User user3 = new User("User3", "securePass321");
        List<User> allUsers = new ArrayList<>();
        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);
        TaskPersistenceManager.saveUsers(allUsers);
        List<User> loadedUsers = TaskPersistenceManager.loadUsers();
        assertEquals(allUsers.size(), loadedUsers.size());
        assertEquals(allUsers.get(0).getUsername(), loadedUsers.get(0).getUsername());
    }

    @Test
    public void testLoadUsersReturnsEmptyWhenFileDoesNotExist() {
        List<User> loadedUsers = TaskPersistenceManager.loadUsers();
        assertTrue(loadedUsers.isEmpty());
    }
}