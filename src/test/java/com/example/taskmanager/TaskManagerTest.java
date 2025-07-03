package com.example.taskmanager;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private TaskManager taskManager;
    private Task task1;
    private Task task2;
    private final int userId = 1;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        task1 = new Task("Title 1", "Description 1");
        task2 = new Task("Title 2", "Description 2");
    }

    @Test
    void testAddTaskSuccessfully() {
        boolean added = taskManager.addTask(task1, userId);// This tests that a new user can create a task successfully as long as they have a valid userId
        assertTrue(added);
        assertEquals(1, taskManager.getUserTasks(userId).size());

        boolean addedAgain = taskManager.addTask(task2, userId);// This tests that a current user can create a task successfully as well
        assertTrue(addedAgain);
        assertEquals(2, taskManager.getUserTasks(userId).size());
    }

    @Test
    void testAddDuplicateTask() {
        taskManager.addTask(task1, userId);                      //This tests that the task manager does not allow the addition of a duplicate task to the same user
        boolean addedAgain = taskManager.addTask(task1, userId);
        assertFalse(addedAgain);

        final int userId2 = 2;                      //This tests that the task manager does allow the addition of a duplicate task to a different user as long as the task has been created
        taskManager.addTask(task1, userId);
        boolean addedAgainForTwo = taskManager.addTask(task1, userId2);
        assertTrue(addedAgainForTwo);
    }

    @Test
    void testAddTaskWithNullTaskOrUserId() {
        assertFalse(taskManager.addTask(null, userId));
        assertFalse(taskManager.addTask(task1, null));
    }

    @Test
    void testUpdateTaskSuccessfully() {
        taskManager.addTask(task1, userId);
        boolean updated = taskManager.updateTask(task1, "completed", userId);
        assertTrue(updated);
        assertEquals(TaskStatus.COMPLETED, task1.getStatus());
    }

    @Test
    void testUpdateTaskFailsForMissingTask() {
        boolean updated = taskManager.updateTask(task1, "PrOgReSsInG", userId);
        assertFalse(updated);
    }

    @Test
    void testUpdateTaskWithInvalidInputs() {
        assertFalse(taskManager.updateTask(null, "COMPLETED", userId));
        assertFalse(taskManager.updateTask(task1, null, userId));
        assertFalse(taskManager.updateTask(task1, "COMPLETED", null));
    }

    @Test
    void testDeleteTaskSuccessfully() {
        taskManager.addTask(task1, userId);
        boolean deleted = taskManager.deleteTask(task1, userId);
        assertTrue(deleted);
        assertTrue(taskManager.getUserTasks(userId).isEmpty());
    }

    @Test
    void testDeleteTaskFailsForInvalidInputs() {
        assertFalse(taskManager.deleteTask(null, userId));
        assertFalse(taskManager.deleteTask(task1, null));
    }

    @Test
    void testGetAllTasksReturnsAllTasks() {
        taskManager.addTask(task1, userId);
        taskManager.addTask(task2, userId);
        List<Task> all = taskManager.getAllTasks();
        assertEquals(2, all.size());
        assertTrue(all.contains(task1));
        assertTrue(all.contains(task2));
    }

    @Test
    void testGetUserTasksReturnsCorrectTasks() {
        taskManager.addTask(task1, userId);
        taskManager.addTask(task2, userId);
        List<Task> userTasks = taskManager.getUserTasks(userId);
        assertEquals(2, userTasks.size());
        taskManager.deleteTask(task2, userId);
        List<Task> userTasks2 = taskManager.getUserTasks(userId);
        assertEquals(1, userTasks2.size());

    }
}