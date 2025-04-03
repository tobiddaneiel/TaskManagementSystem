public class Tasks {
    protected static int ID = 0;
    public String Name;
    public String description;
    public String status;
    public Tasks(String Name, String description,String status){
        this.Name = Name;
        this.description = description;
        this.status = status;
        ID += 1;
    }

}
