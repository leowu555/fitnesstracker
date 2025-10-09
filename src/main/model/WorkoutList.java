package model;

import java.util.ArrayList;
import java.util.List;
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
 * EFFECTS: Add the workout name to the workout list
 */
public void addWorkout(String workoutName) {
}

/*
 * EFFECTS: Check if the workout name is already in the list, 
 * if not in the list, return false, if in the list, return true.
 */
public boolean isWorkoutInList(String workoutName) {
    return false;
}

/*
 * MODIFIES: this
 * EFFECTS: Remove the unwanted workout from the list.
 */
public void removeWorkout(String workoutName) {
}

}


