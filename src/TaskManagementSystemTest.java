import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskManagementSystemTest {
    private TaskManager manager;
    @BeforeEach
    public void setup(){
        manager = new TaskManager();
        Tasks task = new Tasks("Eating food","digestion of food", "In process");
        Tasks task2 = new Tasks("Watching a show","Entertainment", "Stopped");
    }
    @Test
    public void testAddTask(){
        Tasks task = new Tasks("Eating food","digestion of food", "In process");
        Tasks task2 = new Tasks("Watching a show","Entertainment", "Stopped");
        manager.addTask(task);
        assertEquals((manager.tasksNumber),1);
    }

    @Test
    public void testUpdateTask(){
        Tasks task = new Tasks("Eating food","digestion of food", "In process");
        Tasks task2 = new Tasks("Watching a show","Entertainment", "Stopped");
        manager.addTask(task);
        manager.updateTask(task,"Stopped");
        assertEquals((task.status),"Stopped");
        manager.updateTask(task2,"Stopped");
        manager.addTask(task2);
        manager.updateTask(task2,"COMPLETED");
    }

    @Test
    public void testDeleteTask(){
        Tasks task = new Tasks("Eating food","digestion of food", "In process");
        Tasks task2 = new Tasks("Watching a show","Entertainment", "Stopped");
        manager.addTask(task);
        manager.addTask(task2);
        manager.deleteTask(task);
        manager.deleteTask(task);
        manager.deleteTask(task2);
    }

    @Test
    public void testViewTask(){
        Tasks task = new Tasks("Eating food","digestion of food", "In process");
        Tasks task2 = new Tasks("Watching a show","Entertainment", "Stopped");
        manager.viewTask(task);
        manager.addTask(task);
        manager.viewTask(task);
        manager.viewTask(task2);
        manager.addTask(task2);
        manager.viewTask(task2);
    }
}
