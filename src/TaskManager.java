import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private List<Task> allTasks;  //The total lists of tasks that have been added to the manager
    private Map<Integer, List<Task>> userTaskDictionary; //The dictionary containing the key, element pair of the userId and the userTaskList
    //int tasksNumber = 0;
    public TaskManager(){
        this.allTasks = new ArrayList<>();
        this.userTaskDictionary = new LinkedHashMap<>();
    }
    public boolean addTask(Task newTask, Integer userId){
        //Checks that the userId and newTask are both valid
        if (newTask == null || userId == null) return false;

        userTaskDictionary.putIfAbsent(userId, new ArrayList<>());  //If the user doesn't exist it creates a list of tasks and adds to it
        //Checks if the user's list of tasks contains the newTask being added already
        if (!userTaskDictionary.get(userId).contains(newTask)){
            userTaskDictionary.get(userId).add(newTask);                //If not it gets the user's list of tasks and adds the task to it.
            allTasks.add(newTask);  //Adds the task to the total list of tasks
            return true;
        }
        return false;
        //tasksNumber++;
    }
    public boolean updateTask(Task currentTask, TaskStatus statusUpdate, Integer userId){
        //Checks that the userId and currentTask are both valid
        if (currentTask == null || userId == null || statusUpdate == null) return false;
        List<Task> userTaskList= userTaskDictionary.get(userId);   // The list of tasks particular to the user is placed here
        if (userTaskList != null && userTaskList.contains(currentTask)) {     //If the user exists, has a list of tasks and they contain this currentTask
            currentTask.setStatus(statusUpdate);  //the currentTask updates the status
            return true;
        }
        return false;
    }

    public boolean deleteTask(Task currentTask , Integer userId){
        //Checks that the userId and currentTask are both valid
        if (currentTask == null || userId == null) return false;
        List<Task> userTaskList= userTaskDictionary.get(userId);   // The list of tasks particular to the user is placed here
        //If the user's list exists, then it removes the task from the list and the total list of tasks
        if (userTaskList!= null && userTaskList.remove(currentTask)) {
            allTasks.remove(currentTask);
            return true;
        }
        return false;
    }
    public List<Task> getUserTasks(int userId) {
        return userTaskDictionary.getOrDefault(userId, new ArrayList<>()); //This gets the user's list of tasks linked to the id
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(allTasks);  //This gets all tasks present in the taskManager
    }

}
