package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class WorkoutListTest {
    private WorkoutList testWorkoutList;
    private Workout testWorkout1;
    private Workout testWorkout2;

    @BeforeEach
    public void runBefore() {
        testWorkoutList = new WorkoutList("My Workouts to Complete");
        testWorkout1 = new Workout("push-up", 20);
        testWorkout2 = new Workout("sit-up", 10);
    }

    @Test
    void testConstructor() {
        assertEquals(0, testWorkoutList.getSize());
        assertEquals("My Workouts to Complete", testWorkoutList.getListName());
        assertFalse(testWorkoutList.isWorkoutInList(testWorkout1));
    }

    @Test
    void testAddWorkoutOnce() {
        testWorkoutList.addWorkout(testWorkout1);
        assertEquals(1, testWorkoutList.getSize());
        assertTrue(testWorkoutList.isWorkoutInList(testWorkout1));
    }

    @Test
    void testGetWorkoutList() {
        testWorkoutList.addWorkout(testWorkout1);
        testWorkoutList.addWorkout(testWorkout2);
        List<Workout> workoutList = testWorkoutList.getWorkoutList();
        assertEquals(2, workoutList.size());
        assertTrue(workoutList.contains(testWorkout1));
        assertTrue(workoutList.contains(testWorkout2));

    }

    @Test
    void testAddMultipleWorkout() {
        testWorkoutList.addWorkout(testWorkout1);
        testWorkoutList.addWorkout(testWorkout2);
        assertTrue(testWorkoutList.isWorkoutInList(testWorkout1));
        assertTrue(testWorkoutList.isWorkoutInList(testWorkout2));
        assertEquals(2, testWorkoutList.getSize());
    }

    @Test
    void testIsWorkoutInList() {
        testWorkoutList.addWorkout(testWorkout1);
        assertFalse(testWorkoutList.isWorkoutInList(testWorkout2));
        assertTrue(testWorkoutList.isWorkoutInList(testWorkout1));
        testWorkoutList.removeWorkout(testWorkout1);
        assertFalse(testWorkoutList.isWorkoutInList(testWorkout1));

    }

    @Test
    void testRemoveWorkout() {
        testWorkoutList.addWorkout(testWorkout1);
        assertTrue(testWorkoutList.isWorkoutInList(testWorkout1));
        testWorkoutList.removeWorkout(testWorkout1);
        assertFalse(testWorkoutList.isWorkoutInList(testWorkout1));
    }

}
