import java.util.ArrayList;

public class TaskManager {
    ArrayList<Tasks> TaskList =  new ArrayList<>();
    int tasksNumber = 0;
    public TaskManager(){}

    public boolean addTask(Tasks newTask){
        if (newTask == null){
            return false;
        }
        TaskList.add(newTask);
        tasksNumber++;
        return true;
    }
    public boolean updateTask(Tasks newTask, String statusUpdate){
        if (TaskList.contains(newTask)){
            newTask.status = statusUpdate;
            if (newTask.status.equalsIgnoreCase("completed")){
                this.deleteTask(newTask);
            }
            return true;
        }
        System.out.println("No current task with the name \"" + newTask.Name + "\" present");
        return false;
    }
    public boolean deleteTask(Tasks newTask){
        if (!TaskList.contains(newTask)){
            System.out.println("No current task with the name \"" + newTask.Name + "\" present");
            return false;
        }
        TaskList.remove(newTask);
        tasksNumber --;
        System.out.println("\"" + newTask.Name + "\" " + "has been removed from the current list of tasks.");
        return true;
    }
    public void viewTask(Tasks newTask){
        if (!TaskList.contains(newTask)) {
            System.out.println("No such tasks have been added");
        }else
            System.out.println(newTask.Name + "," + newTask.description + "," + newTask.status + ".");
    }
}
