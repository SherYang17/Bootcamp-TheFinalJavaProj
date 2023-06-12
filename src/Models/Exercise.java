package Models;

public class Exercise {
    private String exerciseType;
    private int duration;
    private int caloriesBurned;

    public Exercise(String exerciseType, int duration, int caloriesBurned) {
        this.exerciseType = exerciseType;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }
}
