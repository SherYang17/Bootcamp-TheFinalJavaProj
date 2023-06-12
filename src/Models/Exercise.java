package Models;

import java.util.Date;

public class Exercise {
    private String type;
    private int duration;
    private int caloriesBurned;
    private Date date;

    public Exercise(String type, int duration, int caloriesBurned) {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.date = new Date();
    }

    public String getName() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public Date getDate() {
        return date;
    }

}

