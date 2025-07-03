import java.util.Scanner;

import model.User;
import service.AuthService;
import service.BankingService;

public class Main {
    public static void main(String[] args) {
        User user = new User("soyal", "normal123", "emergency911");
        AuthService authService = new AuthService();
        BankingService bankingService = new BankingService();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String uname = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (!uname.equals(user.getUsername())) {
            System.out.println(" Invalid username.");
            return;
        }

        AuthService.LoginStatus status = authService.login(user, password);

        switch (status) {
            case NORMAL -> {
                System.out.println("Logged in successfully.");
            }
            case EMERGENCY -> {
                System.out.println("Emergency login activated.");
                bankingService.setEmergencyMode(true);
            }
            case FAILED -> {
                System.out.println(" Login failed. Invalid credentials.");
                return;
            }
        }

        System.out.print("Enter transaction type (withdraw/deposit): ");
        String type = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        bankingService.performTransaction(type, amount);
    }
}