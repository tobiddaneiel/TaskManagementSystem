public class User {
    private static Integer idCounter = 0;
    private final Integer id;
    private String username;
    private String password;
    public User(String username, String password){
        if (username == null || username.trim().isEmpty()) throw new IllegalArgumentException("Username can not be empty");
        if (password == null || password.length() <= 7) throw new IllegalArgumentException("Password must be at least 8 characters");
        this.id = ++idCounter;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) throw new IllegalArgumentException("Username can not be empty");
        this.username = username;
    }

    public void setPassword(String password) {
        if (password == null || password.length() <= 7) throw new IllegalArgumentException("Password must be at least 8 characters");
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User id: " + id +
                ", Username: " + username ;
    }
}
