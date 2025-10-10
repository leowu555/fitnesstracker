package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class WorkoutTest {
    private Workout testWorkout;


    @BeforeEach
    void runBefore() {
        testWorkout = new Workout("bench press", 20);
    }

    @Test
    void testConstructor() {
        assertEquals("bench press", testWorkout.getName());
        assertEquals(20, testWorkout.getDuration());
    }

    @Test
    void testGetName() {
        assertEquals("bench press", testWorkout.getName());
    }

    @Test
    void testGetDuration() {
        assertEquals(20, testWorkout.getDuration());
    }

    @Test
    void testSetDuration() {
        testWorkout.setDuration(35);
        assertEquals(35, testWorkout.getDuration());
        testWorkout.setDuration(25);
        assertEquals(25, testWorkout.getDuration());
    }

    @Test
    void testIsCompleted() {
        testWorkout.getName();
        assertFalse(testWorkout.isCompleted());

    }

    @Test
    void testMarkComplete() {
        assertFalse(testWorkout.isCompleted());
        testWorkout.markComplete();
        assertTrue(testWorkout.isCompleted());
    }

}
