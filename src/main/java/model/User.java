package model;

public class User {
    private int id;
    private String username;
    private String password;
    private String role;

    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public String getUsername(){
        return username;
    };
    public String getRole(){
        return role;
    };
    public String getPassword(){
        return password;
    };

    // Getters and Setters
}

