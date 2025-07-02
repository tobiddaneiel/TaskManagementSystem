package com.example.taskmanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskPersistenceTest {

    private final String tempFilePath = "temp_tasks.json";

    @AfterEach
    public void cleanup() {
        File file = new File(tempFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testSaveAndLoadTasks() {
        List<Task> tasks = List.of(new Task("Sample Task", "Description"));
        // Save to temp file
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(tempFilePath), tasks);
        } catch (IOException e) {
            fail("Saving failed: " + e.getMessage());
        }

        // Load from temp file
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Task> loaded = mapper.readValue(new File(tempFilePath), new TypeReference<>() {});
            assertEquals(tasks.size(), loaded.size());
            assertEquals(tasks.get(0).getTitle(), loaded.get(0).getTitle());
        } catch (IOException e) {
            fail("Loading failed: " + e.getMessage());
        }
    }
}
