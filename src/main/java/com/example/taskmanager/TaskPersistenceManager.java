package com.example.taskmanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskPersistenceManager {
    private static final String FILE_PATH = "tasks.json";  // You can change the path if needed
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void saveTasks(Map<Integer, List<Task>> userTaskDictionary) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), userTaskDictionary);
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static Map<Integer, List<Task>> loadTasks() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new HashMap<>();  // return empty if no file exists yet
            }
            return mapper.readValue(file, new TypeReference<Map<Integer, List<Task>>>() {});
        } catch (IOException e) {
            System.err.println("Error loading tasks: " + e.getMessage());
            return new HashMap<>();  // return empty on error
        }
    }
}
