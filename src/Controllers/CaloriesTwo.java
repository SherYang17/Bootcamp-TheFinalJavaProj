package Controllers;

import java.io.FileWriter;
import java.io.IOException;

public class CaloriesTwo {
    private static final String CALORIE_INTAKE_FILE = "src/Viewer/calorie_intake.txt";

    public void storeCalorieIntake(String data) {
        try (FileWriter writer = new FileWriter(CALORIE_INTAKE_FILE, true)) {
            writer.write(data + "\n");
            System.out.println("Calorie intake stored successfully.");
        } catch (IOException e) {
            System.out.println("Error storing calorie intake: " + e.getMessage());
        }
    }

    public void storeCalorieIntake(String foodItem, int calories, String date) {
        String data = "Date: " + date + ", Food Item: " + foodItem + ", Calorie Intake: " + calories;
        storeCalorieIntake(data);
    }


}
