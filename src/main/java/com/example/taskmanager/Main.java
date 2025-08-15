package com.example.taskmanager;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager();
    private static final UserManager userManager = new UserManager();
    private static User currentUser = null;

    public static void main(String[] args) {
        taskManager.loadAllTasksFromFile();
        userManager.loadAllUsersFromFile();

        System.out.println("Welcome to Task Manager!");
        while (true) {
            if (currentUser == null){
                showDefaultMenu();
            }
            else
                showMainMenu();
        }
    }

    private static void showDefaultMenu() {
        System.out.println("\n1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("Choose an option:");
        String input = scanner.nextLine();
        switch (input){
            case "1":
                register();break;
            case "2":
                login();break;
            case "3": System.exit(0);
            default:
                System.out.println("Invalid choice.");//throw new IllegalStateException("Unexpected value: " + input);
        }
    }

    private static void showMainMenu() {
        System.out.println("\n1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Get Your Tasks");
        System.out.println("5. Get All Tasks");
        System.out.println("6. Save");
        System.out.println("7. Logout");
        System.out.println("Choose an option:");
        String input = scanner.nextLine();
        switch (input){
            case "1": addTask();break;
            case "2": updateTask();break;
            case "3": deleteTask();break;
            case "4": getYourTasks();break;
            case "5": getAllTasks();break;
            case "6": saveAllTasksToFile();break;
            case "7": currentUser = null;break;
            default:
                System.out.println("Invalid choice.");//throw new IllegalStateException("Unexpected value: " + input);
        }
    }


    private static void deleteTask() {
        System.out.println("Enter task ID to delete:");
        Integer ID = Integer.parseInt(scanner.nextLine());
        //System.out.println(taskManager.getTask(ID).toString());
        taskManager.deleteTask(taskManager.getTask(ID), currentUser.getId());
        System.out.println("Task deleted successfully.");
    }

    private static void updateTask() {
        System.out.println("Enter task ID to update:");
        Integer ID = Integer.parseInt(scanner.nextLine());
        System.out.println(taskManager.getTask(ID).toString());
        System.out.println("Enter task status update (OPENED, PROGRESSING, COMPLETED) :");
        String description = scanner.nextLine();
        taskManager.updateTask(taskManager.getTask(ID),description, currentUser.getId());
        System.out.println("Task status updated successfully.");
    }

    private static void addTask() {
        try {
            System.out.println("Enter task title:");
            String title = scanner.nextLine();
            System.out.println("Enter task description:");
            String description = scanner.nextLine();
            Task task = new Task(title, description);
            taskManager.addTask(task, currentUser.getId());
            System.out.println(task.getTitle() + " Task with ID: " + task.getId() + " added successfully.");
        }catch (IllegalArgumentException e){
            System.out.println(e.toString() + "\nAdd task again.");
        }
        addTask();
    }

    private static void getYourTasks() {
        System.out.println(taskManager.getUserTasks(currentUser.getId()));
    }

    private static void getAllTasks() {
        System.out.println(taskManager.getAllTasks());;
    }

    private static void saveAllTasksToFile() {
        taskManager.saveAllTasksToFile();
    }

    private static void login() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        currentUser = userManager.login(username, password);
        //System.out.println("User logged in successfully.");
    }

    private static void register() {
        boolean userCreated = false;
        User user = null;
        while (!userCreated){
            try {
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                user = new User(username, password);
                userCreated = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.toString() + "\nRegister again.");
            }
        }
        try {
            userManager.register(user);
        }catch (NullPointerException e){
            System.out.println(e.toString() + "\nRegister again.");
        }
        userManager.saveAllUsersToFile();
        //System.out.println("User registered successfully.");
    }
}
