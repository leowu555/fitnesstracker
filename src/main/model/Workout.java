package model;

// Represents a workout that needs to be completed or has already completed.
public class Workout {
    private String name;
    private int minsNeeded;
    private boolean hasCompleted;

    /*
     * REQUIRES: minsNeeded > 0, workoutName has non-zero positive length.
     * EFFECTS: Construct a workout that includes a name and the minutes needed to
     * complete this workout.
     */
    public Workout(String workoutName, int minsNeeded) {
        name = workoutName;
        this.minsNeeded = minsNeeded;
        this.hasCompleted = false;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return minsNeeded;
    }

    public void setDuration(int newDuration) {
        this.minsNeeded = newDuration;

    }

    /*
     * EFFECTS: Check if the workout is completed. Return true if the workout is
     * completed, false otherwise.
     */
    public boolean isCompleted() {
        if (hasCompleted == true) {
            return true;
        }
        return false;
    }

    /*
     * MODIFIES: this
     * EFFECTS: Mark the workout as complete if it is incomplete.
     */
    public void markComplete() {
        this.hasCompleted = true;
    }

}
