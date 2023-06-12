package Controllers;

import Models.Exercise;
import Models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                    calculateDailyCaloricBalance();
                    break;
                case 2:
                    displaySleepRecords();
                    break;
                case 3:
                    displayExerciseLog();
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


    } // end of analyze health



    private void calculateDailyCaloricBalance() {
        User currentUser = userManager.getCurrentUser();
        Scanner scanner = new Scanner(System.in);


        // Get the date for which to calculate the caloric balance
        System.out.print("Enter the date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();

        // Retrieve the calorie intake and exercise data for the specified date
        int calorieIntake = currentUser.getCalorieIntake(dateStr);
        int caloriesBurned = currentUser.getCaloriesBurned(dateStr);

        // Calculate the daily caloric balance
        int caloricBalance = calorieIntake - caloriesBurned;

        // Display the daily caloric balance
        System.out.println("Daily Caloric Balance for " + dateStr + ": " + caloricBalance);
    }

    public void displaySleepRecords() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Viewer/sleep_records.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the sleep records file.");
            e.printStackTrace();
        }
    }




    private void displayExerciseLog() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Viewer/exercise.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Exercise Type: ")) {
                    String exerciseType = line.substring("Exercise Type: ".length());
                    String durationLine = reader.readLine();
                    String caloriesLine = reader.readLine();

                    int duration = Integer.parseInt(durationLine.substring("Duration: ".length(), durationLine.indexOf(" minutes")));
                    int caloriesBurned = Integer.parseInt(caloriesLine.substring("Calories Burned: ".length()));

                    Exercise entry = new Exercise(exerciseType, duration, caloriesBurned);
                    System.out.println("Exercise Type: " + entry.getExerciseType());
                    System.out.println("Duration: " + entry.getDuration() + " minutes");
                    System.out.println("Calories Burned: " + entry.getCaloriesBurned());
                    System.out.println();
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the exercise log.");
            e.printStackTrace();
        }
    }




}
