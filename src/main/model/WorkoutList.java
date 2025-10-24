package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of workouts that needs to be completed.
public class WorkoutList {
    private List<Workout> workoutList;
    private String name;

    /*
     * EFFECTS: Construct an empty workout list that the user will complete.
     */
    public WorkoutList(String name) {
        this.workoutList = new ArrayList<>();
        this.name = name;
    }

    /*
     * MODIFIES: this
     * EFFECTS: Add the workout name to the workout list.
     */
    public void addWorkout(Workout workoutName) {
        workoutList.add(workoutName);
    }

    public List<Workout> getWorkoutList() {
        return workoutList;
    }

    /*
     * EFFECTS: Check if the workout name is already in the list,
     * if not in the list, return false, if in the list, return true.
     */
    public boolean isWorkoutInList(Workout workoutName) {
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
    public void removeWorkout(Workout workoutName) {
        workoutList.remove(workoutName);
    }

    /*
     * REQUIRES: the list size is non-zero.
     * EFFECTS: Returns the size of the list.
     */
    public int getSize() {
        return workoutList.size();
    }

    public String getListName() {
        return name;
    }

}
