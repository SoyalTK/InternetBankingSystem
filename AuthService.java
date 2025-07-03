package service;

import model.User;

public class AuthService {
    public enum LoginStatus {
        NORMAL, EMERGENCY, FAILED
    }

    public LoginStatus login(User user, String inputPassword) {
        if (inputPassword.equals(user.getPassword())) {
            return LoginStatus.NORMAL;
        } else if (inputPassword.equals(user.getEmergencyPassword())) {
            return LoginStatus.EMERGENCY;
        } else {
            return LoginStatus.FAILED;
        }
    }
}