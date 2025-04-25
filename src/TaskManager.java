import java.util.ArrayList;

public class TaskManager {
    ArrayList<Task> TaskList =  new ArrayList<>();
    int tasksNumber = 0;
    public TaskManager(){}

    public boolean addTask(Task newTask){
        if (newTask == null){
            return false;
        }
        TaskList.add(newTask);
        tasksNumber++;
        return true;
    }
    public boolean updateTask(Task newTask, String statusUpdate){
        if (TaskList.contains(newTask)){
            newTask.status = statusUpdate;
            if (newTask.status.equalsIgnoreCase("completed")){
                this.deleteTask(newTask);
            }
            return true;
        }
        System.out.println("No current task with the name \"" + newTask.Title + "\" present");
        return false;
    }
    public boolean deleteTask(Task newTask){
        if (!TaskList.contains(newTask)){
            System.out.println("No current task with the name \"" + newTask.Title + "\" present");
            return false;
        }
        TaskList.remove(newTask);
        tasksNumber --;
        System.out.println("\"" + newTask.Title + "\" " + "has been removed from the current list of tasks.");
        return true;
    }
    public void viewTask(Task newTask){
        if (!TaskList.contains(newTask)) {
            System.out.println("No such tasks have been added");
        }else
            System.out.println(newTask.Title + "," + newTask.description + "," + newTask.status + ".");
    }
}
