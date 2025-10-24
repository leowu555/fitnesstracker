package persistence;

import model.Workout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class JsonTest {
    protected void checkWorkout(String name, int minsNeeded, boolean hasCompleted, Workout workout) {
        assertEquals(name, workout.getName());
        assertEquals(minsNeeded, workout.getDuration());
        assertEquals(hasCompleted, workout.isCompleted());
    }
}