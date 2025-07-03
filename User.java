package model;

public class User {
    private String username;
    private String password;
    private String emergencyPassword;

    public User(String username, String password, String emergencyPassword) {
        this.username = username;
        this.password = password;
        this.emergencyPassword = emergencyPassword;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmergencyPassword() { return emergencyPassword; }
}