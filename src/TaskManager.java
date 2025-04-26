import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private List<Task> taskList;
    private List<Task> userTaskList;
    private Map<Integer, List<Task>> userTaskDictionary;
    //int tasksNumber = 0;
    public TaskManager(){
        this.taskList = new ArrayList<>();
        this.userTaskDictionary = new LinkedHashMap<>();
    }
    public void addTask(Task newTask, Integer userId){
        if (newTask != null){
            taskList.add(newTask);
            userTaskDictionary.put(userId,userTaskList);
            return;
        }

        //tasksNumber++;
    }
    //public boolean updateTask(Task newTask, String statusUpdate){
    //    if (taskList.contains(newTask)){
    //        newTask.status = statusUpdate;
    //        if (newTask.status.equalsIgnoreCase("completed")){
    //            this.deleteTask(newTask);
    //        }
    //        return true;
    //    }
    //    System.out.println("No current task with the name \"" + newTask.Title + "\" present");
    //    return false;
    //}
    //public boolean deleteTask(Task newTask){
    //    if (!taskList.contains(newTask)){
    //        System.out.println("No current task with the name \"" + newTask.Title + "\" present");
    //        return false;
    //    }
    //    taskList.remove(newTask);
    //    tasksNumber --;
    //    System.out.println("\"" + newTask.Title + "\" " + "has been removed from the current list of tasks.");
    //    return true;
    //}
    //public void viewTask(Task newTask){
    //    if (!taskList.contains(newTask)) {
    //        System.out.println("No such tasks have been added");
    //    }else
    //        System.out.println(newTask.Title + "," + newTask.description + "," + newTask.status + ".");
    //}
}
