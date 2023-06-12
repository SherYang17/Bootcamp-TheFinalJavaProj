package Models;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private Map<String, Integer> calorieIntakeMap;

    public User(String username) {
        this.username = username;
        this.calorieIntakeMap = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void logCalorieIntake(String date, int calorieIntake) {
        calorieIntakeMap.put(date, calorieIntake);
    }

    public int getCalorieIntake(String date) {
        return calorieIntakeMap.getOrDefault(date, 0);
    }

    public void logCaloriesBurned(String date, int caloriesBurned) {
        // Implement the logic to store calories burned for each date
    }

    public int getCaloriesBurned(String date) {
        // Implement the logic to retrieve calories burned for a specific date
        return 0;
    }
}
