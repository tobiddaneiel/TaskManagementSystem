public enum TaskStatus {
    OPENED,
    PROGRESSING,
    COMPLETED;
    public static TaskStatus fromString(String status){
        if (status == null) throw new IllegalArgumentException("Status can not be null");
        try{
            return TaskStatus.valueOf(status.trim().toUpperCase());
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid task status:" + status);
        }
    }
}
