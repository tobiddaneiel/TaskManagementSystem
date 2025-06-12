public class Task {
    private static int idCounter = 0;
    private final int id;
    private String title;
    private String description;
    private TaskStatus status;
    public Task(String title, String description){
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title can not be empty");
        this.title = title;
        this.description = description;
        this.status = TaskStatus.OPENED;
        this.id = ++idCounter;
    }
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public TaskStatus getStatus() {
        return status;
    }
    public void setStatus(TaskStatus status) {
        if (status == null) throw new IllegalArgumentException("status can not be null");
        this.status = status;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title can not be empty");
        this.title = title;
    }

    @Override
    public String toString() {
        return "Task id: " + id +
                ", Title: " + title +
                ", Description: " + description +
                ", Status: " + status;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
