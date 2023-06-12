package Controllers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();
        HealthDataManager healthDataManager = new HealthDataManager(userManager);

        boolean loggedIn = userManager.userLogin(scanner);

        if (loggedIn) { // ahmad
            System.out.println("Logged In Successfully!");
            runHealthMenu(); // Menu to prompt Health Input or Health Analyzer

        }


    }// end of login

    public static void runHealthMenu() { // Run health menu to call 2 classes in each switch. Each switch method goes to their classes.
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        UserManager userManager = new UserManager();
        HealthDataManager manager = new HealthDataManager(userManager);
        HealthDataAnalyzer analyze = new HealthDataAnalyzer(userManager);

        while (running) {
            System.out.println("1. Health Data Input");
            System.out.println("2. Health Data Analysis");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    manager.healthDataInput();
                    break;
                case 2:
                    analyze.analyzeHealth();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
