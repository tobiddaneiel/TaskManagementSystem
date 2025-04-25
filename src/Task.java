public class Task {
    private static int IdCounter = 0;
    private static final String DEFAULT_STATUS = "Opened";
    private int ID;
    private String title;
    private String description;
    private String status;
    public Task(String title, String description){
        this.title = title;
        this.description = description;
        this.status = DEFAULT_STATUS;
        this.ID = ++IdCounter;
    }
    public int getID() {
        return ID;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Task ID: " + ID +
                ", Title: " + title +
                ", Description: " + description +
                ", Status: " + status;
    }
}
