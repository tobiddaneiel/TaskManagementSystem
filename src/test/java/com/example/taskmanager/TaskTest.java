package com.example.taskmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testDefaultConstructor() {
        Task task = new Task();
        assertEquals("Default Task", task.getTitle());
        assertEquals("", task.getDescription());
        assertEquals(TaskStatus.OPENED, task.getStatus());
        assertTrue(task.getId() > 0);
    }

    @Test
    public void testParameterizedConstructorAndGetId() {
        Task task = new Task("Test Title", "Test Description");
        assertEquals("Test Title", task.getTitle());
        assertEquals("Test Description", task.getDescription());
        assertEquals(TaskStatus.OPENED, task.getStatus());
        assertTrue(task.getId() > 0);
    }

    @Test
    public void testParameterizedConstructorThrows() {
        assertThrows(IllegalArgumentException.class, () -> {new Task("", "Test Description");});
        assertThrows(IllegalArgumentException.class, () -> {new Task("  ", "Test Description");});
        assertThrows(IllegalArgumentException.class, () -> {new Task(null, "Test Description");});
    }

    @Test
    public void testSetTitleAndGetTitle() {
        Task task = new Task();
        task.setTitle("New Title");
        assertEquals("New Title", task.getTitle());
    }

    @Test
    public void testSetTitleThrowsException() {
        Task task = new Task();
        assertThrows(IllegalArgumentException.class, () -> task.setTitle(null));
        assertThrows(IllegalArgumentException.class, () -> task.setTitle("  "));
        assertThrows(IllegalArgumentException.class, () -> task.setTitle(""));
    }

    @Test
    public void testSetStatusAndGetStatus() {
        Task task = new Task();
        task.setStatus("Opened");
        assertEquals(TaskStatus.OPENED, task.getStatus());
    }

    @Test
    public void testSetStatusThrowsException() {
        Task task = new Task();
        assertThrows(IllegalArgumentException.class, () -> task.setStatus(null));
        assertThrows(IllegalArgumentException.class, () -> task.setStatus("TaskStatus.PROGRESSING"));
        assertThrows(IllegalArgumentException.class, ()->task.setStatus("created"));
    }

    @Test
    public void testSetDescription() {
        Task task = new Task();
        task.setDescription("Updated description");
        assertEquals("Updated description", task.getDescription());
    }

    @Test
    public void testToStringIncludesAllFields() {
        Task task = new Task("Task A", "Desc");
        String result = task.toString();
        assertTrue(result.contains("Task id:"));
        assertTrue(result.contains("Title: Task A"));
        assertTrue(result.contains("Description: Desc"));
        assertTrue(result.contains("Status: OPENED"));
        task.setStatus("completed");
        result = task.toString();
        assertTrue(result.contains("Status: COMPLETED"));
    }
}
