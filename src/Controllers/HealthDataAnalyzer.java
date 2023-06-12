package Controllers;

import java.util.Scanner;

public class HealthDataAnalyzer {
    private UserManager userManager;

    public HealthDataAnalyzer(UserManager userManager) {
        this.userManager = userManager;
    }

    public void placeholder(Scanner scanner) {
        System.out.println("placeholder for now");
    }

    public void analyzeHealth() {
        Scanner scanner = new Scanner(System.in);
        boolean inputRunning = true;

        while (inputRunning) {
            System.out.println("Health Data Analysis");
            System.out.println("1. Daily Caloric Balance");
            System.out.println("2. Sleep Analysis");
            System.out.println("3. Exercise Log");
            System.out.println("4. Health Summary");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
//                    logDailyCalorieIntake(scanner);
                    break;
                case 2:
//                    logExerciseActivity(scanner);
                    break;
                case 3:
//                    logSleepRecords(scanner);
                    break;
                case 4:
                    // Health Summmary
                    break;
                case 0:
                    inputRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }


    }
}
