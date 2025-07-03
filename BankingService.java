package service;

public class BankingService {
    private boolean isEmergency = false;

    public void setEmergencyMode(boolean status) {
        this.isEmergency = status;
    }

    public void performTransaction(String action, double amount) {
        if (isEmergency) {
            System.out.println("Transaction failed due to technical error. Please contact support.");
            triggerEmergencyAlert();
        } else {
            System.out.printf("Transaction successful: %s of ₹%.2f%n", action, amount);
        }
    }

    private void triggerEmergencyAlert() {
        System.out.println("⚠ ALERT: Emergency login detected. Security team notified.");
    }
}