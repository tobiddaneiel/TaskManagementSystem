import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskManagementSystemTest {
    private TaskManager manager;
    private Tasks task;
    private Tasks task2;
    @BeforeEach
    public void setup(){
        manager = new TaskManager();
        task = new Tasks("Eating food","digestion of food", "In process");
        task2 = new Tasks("Watching a show","Entertainment", "Stopped");
    }
    @Test
    public void testAddTask(){
        manager.addTask(task);
        assertEquals((manager.tasksNumber),1);
        assertEquals((task.ID),1);
        assertEquals((task2.ID),2);}

    @Test
    public void testUpdateTask(){
        manager.addTask(task);
        manager.updateTask(task,"Stopped");
        assertEquals((task.status),"Stopped");
        manager.updateTask(task2,"Stopped");
        manager.addTask(task2);
        manager.updateTask(task2,"COMPLETED");
    }

    @Test
    public void testDeleteTask(){
        manager.addTask(task);
        manager.addTask(task2);
        manager.deleteTask(task);
        manager.deleteTask(task);
        manager.deleteTask(task2);
    }

    @Test
    public void testViewTask(){
        manager.viewTask(task);
        manager.addTask(task);
        manager.viewTask(task);
        manager.viewTask(task2);
        manager.addTask(task2);
        manager.viewTask(task2);
    }
}
