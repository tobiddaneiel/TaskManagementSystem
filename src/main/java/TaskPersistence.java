import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TaskPersistence {
    private static final String FILE_PATH = "tasks.json";  // You can change the path if needed
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void saveTasks(List<Task> tasks) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), tasks);
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static List<Task> loadTasks() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return List.of();  // return empty if no file exists yet
            }
            return mapper.readValue(file, new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            System.err.println("Error loading tasks: " + e.getMessage());
            return List.of();  // return empty on error
        }
    }
}
