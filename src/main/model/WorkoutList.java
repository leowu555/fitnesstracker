package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of workouts that needs to be completed.
public class WorkoutList {
    private List<String> workoutList;

    /*
     * EFFECTS: Construct an empty workout list that the user will complete.
     */
    public WorkoutList() {
        this.workoutList = new ArrayList<>();
    }

    /*
     * MODIFIES: this
     * EFFECTS: Add the workout name to the workout list.
     */
    public void addWorkout(String workoutName) {
        workoutList.add(workoutName);
    }

    public List<String> getWorkoutList() {
        return workoutList;
    }

    /*
     * EFFECTS: Check if the workout name is already in the list,
     * if not in the list, return false, if in the list, return true.
     */
    public boolean isWorkoutInList(String workoutName) {
        for (int i = 0; i < workoutList.size();) {
            if (workoutList.contains(workoutName)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /*
     * MODIFIES: this
     * EFFECTS: Remove the workoutname of the workout that is completed from the
     * workoutList.
     */
    public void removeWorkout(String workoutName) {
        workoutList.remove(workoutName);
    }

    /*
     * REQUIRES: the list size is non-zero.
     * EFFECTS: Returns the size of the list.
     */
    public int size() {
        return workoutList.size();
    }

}
