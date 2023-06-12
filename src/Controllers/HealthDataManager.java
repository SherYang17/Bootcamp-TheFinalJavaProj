package Controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HealthDataManager {
    private UserManager userManager;
    private CaloriesTwo caloriesTwo;

    public HealthDataManager(UserManager userManager) {
        this.userManager = userManager;
        this.caloriesTwo = new CaloriesTwo();
    }


    public void healthDataInput() {
        Scanner scanner = new Scanner(System.in);
        boolean inputRunning = true;

        while (inputRunning) {
            System.out.println("Health Data Input");
            System.out.println("1. Daily Calorie Intake");
            System.out.println("2. Exercise Activities");
            System.out.println("3. Sleep Records");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    logDailyCalorieIntake(scanner);
                    break;
                case 2:
                    logExerciseActivity(scanner);
                    break;
                case 3:
                    logSleepRecords(scanner);
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



    private void logDailyCalorieIntake(Scanner scanner) {
        System.out.print("Enter the food item: ");
        String foodItem = scanner.nextLine();

        System.out.print("Enter the calorie intake: ");
        int calories = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        caloriesTwo.storeCalorieIntake(foodItem, calories);
    }


    private void logExerciseActivity(Scanner scanner) {
        System.out.print("Enter the type of exercise: ");
        String exerciseType = scanner.nextLine();

        System.out.print("Enter the duration of exercise (in minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the estimated calories burned: ");
        int caloriesBurned = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("src/Viewer/exercise.txt", true));
            writer.println("Exercise Type: " + exerciseType);
            writer.println("Duration: " + duration + " minutes");
            writer.println("Calories Burned: " + caloriesBurned);
            writer.close();
            System.out.println("Exercise activity saved to exercise.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the exercise activity.");
            e.printStackTrace();
        }
    }

    private void logSleepRecords(Scanner scanner) {
        // TODO: Implement sleep record logging logic
    }

    private void healthDataAnalysis() {
        // TODO: Implement health data analysis logic
    }
}
