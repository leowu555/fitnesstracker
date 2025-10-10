package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class WorkoutListTest {
    private WorkoutList testWorkoutList;

    @BeforeEach
    public void runBefore() {
        testWorkoutList = new WorkoutList();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testWorkoutList.size());
        assertFalse(testWorkoutList.isWorkoutInList("pushup"));
    }

    @Test
    void testAddWorkoutOnce() {
        testWorkoutList.addWorkout("pushups");
        assertEquals(1, testWorkoutList.size());
        assertTrue(testWorkoutList.isWorkoutInList("pushups"));
    }

    @Test
    void testAddMultipleWorkout() {
        testWorkoutList.addWorkout("squats");
        testWorkoutList.addWorkout("dips");
        testWorkoutList.addWorkout("situps");

        assertTrue(testWorkoutList.isWorkoutInList("squats"));
        assertTrue(testWorkoutList.isWorkoutInList("dips"));
        assertTrue(testWorkoutList.isWorkoutInList("situps"));

        assertEquals(3, testWorkoutList.size());
    }

    @Test
    void testIsWorkoutInList() {
        testWorkoutList.addWorkout("pushups");
        assertFalse(testWorkoutList.isWorkoutInList("situps"));
        assertTrue(testWorkoutList.isWorkoutInList("pushups"));
        testWorkoutList.removeWorkout("pushups");
        assertFalse(testWorkoutList.isWorkoutInList("pushups"));

    }

    @Test
    void testRemoveWorkout() {
        testWorkoutList.addWorkout("bench press");
        assertTrue(testWorkoutList.isWorkoutInList("bench press"));
        testWorkoutList.removeWorkout("bench press");
        assertFalse(testWorkoutList.isWorkoutInList("bench press"));
    }

}
