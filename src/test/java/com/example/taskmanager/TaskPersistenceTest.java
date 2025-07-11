package com.example.taskmanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskPersistenceTest {

    private final String tempFilePath = "temp_tasks.json";
    @BeforeEach
    public void clearFileBeforeTest() {
        File file = new File(tempFilePath);
        if (file.exists()) {
            file.delete();
        }
    }
    @AfterEach
    public void cleanupAfterTest() {
        File file = new File(tempFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testSaveAndLoadTasks() {
        //List<Task> tasks = List.of(new Task("Sample Task", "Description"));
        Task task1 = new Task("Sample Task", "Description");
        Task task2 = new Task("Sample Task 2", "Description 2");
        Map<Integer, List<Task>> userTaskDictionary = Map.of(1, List.of(task1, task2));
        TaskPersistenceManager.saveTasks(userTaskDictionary);
        Map<Integer, List<Task>> loadedTaskDictionary = TaskPersistenceManager.loadTasks();
        assertEquals(userTaskDictionary.size(), loadedTaskDictionary.size());
        assertEquals(userTaskDictionary.get(1).get(0).getTitle(), loadedTaskDictionary.get(1).get(0).getTitle());
        
    }
}
