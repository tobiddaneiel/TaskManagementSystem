package com.example.taskmanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TaskPersistenceTest {

    private final String tempFilePath = "temp_tasks.json";

    @BeforeEach
    public void setup() {
        TaskPersistenceManager.setFilePath(tempFilePath);
    }
    @AfterEach
    public void cleanup() {
        boolean deleted = new File(tempFilePath).delete();
        if (!deleted) {
            //System.err.println("Failed to delete temp file: " + tempFilePath);
        }
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
    void testLoadTasksFromCorruptedJsonFile() {
        // Arrange: create a corrupted JSON file
        File corruptedFile = new File("temp_tasks_2.json");
        TaskPersistenceManager.setFilePath("temp_tasks_2.json");

        try (var writer = new java.io.FileWriter(corruptedFile)) {
            writer.write("{ invalid json: ["); // Malformed JSON
        } catch (Exception e) {
            fail("Failed to set up corrupted file for test.");
        }

        // Act: attempt to load the corrupted file
        Map<Integer, List<Task>> result = TaskPersistenceManager.loadTasks();

        // Assert: should return an empty map and not throw
       assertTrue(result.isEmpty(), "Expected empty map on corrupted JSON input.");
    }

}
