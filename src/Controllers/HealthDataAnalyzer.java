package Controllers;

import Models.Exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
//                    logDailyCalorieIntake(scanner);
                    break;
                case 2:
//                    logExerciseActivity(scanner);
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
