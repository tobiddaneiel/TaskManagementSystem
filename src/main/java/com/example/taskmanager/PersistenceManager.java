package com.example.taskmanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersistenceManager {
    private static String TASK_FILE_PATH = "tasks.json";  // You can change the path if needed
    private static String USER_FILE_PATH = "users.json";  // You can change the path if needed
    private static final ObjectMapper mapper = new ObjectMapper();


    public static void setTaskFilePath(String filePath) {
        TASK_FILE_PATH = filePath;
    }
    public static void setUserFilePath(String filePath) {
        USER_FILE_PATH = filePath;
    }
    public static void saveTasks(Map<Integer, List<Task>> userTaskDictionary) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(TASK_FILE_PATH), userTaskDictionary);
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static Map<Integer, List<Task>> loadTasks() {
        try {
            File file = new File(TASK_FILE_PATH);
            if (!file.exists()) {
                return new HashMap<>();  // return empty if no file exists yet
            }
            return mapper.readValue(file, new TypeReference<Map<Integer, List<Task>>>() {});
        } catch (IOException e) {
            System.err.println("Error loading tasks: " + e.getMessage());
            return new HashMap<>();  // return empty on error
        }
    }

    public static void saveUsers(List<User> allUsers) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(USER_FILE_PATH), allUsers);
            System.out.println("New user saved successfully.");
        } catch (IOException e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
    }
    public static List<User> loadUsers(){
        try {
            File file = new File(USER_FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();  // return empty if no file exists yet
            }
            return mapper.readValue(file, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            System.err.println("Error loading users: " + e.getMessage());
            return new ArrayList<>();  // return empty on error
        }
    }
}
