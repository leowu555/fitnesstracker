package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GoalsTest {
    private Goals testGoalsA;
    private Goals testGoalsB;

    @BeforeEach
    void runBefore() {
        testGoalsA = new Goals("bench 225 pounds");
        testGoalsB = new Goals("keep my weight less than 160 pounds");
    }

    @Test
    void testConstructor() {
        assertEquals("bench 225 pounds", testGoalsA.getGoals());
        assertEquals("keep my weight less than 160 pounds", testGoalsB.getGoals());
    }

    @Test
    void testSetGoals() {
        testGoalsA.setGoals("squat 225 pounds");
        assertEquals("squat 225 pounds", testGoalsA.getGoals());
        testGoalsB.setGoals("Consume 150 grams of protein");
        assertEquals("Consume 150 grams of protein", testGoalsB.getGoals());

    }

    @Test
    void testGetGoals() {
        assertEquals("bench 225 pounds", testGoalsA.getGoals());
        testGoalsA.setGoals("30 pushups");
        assertEquals("30 pushups", testGoalsA.getGoals());
    }


    @Test
    void testAddProteinOnce() {
        testGoalsA.addProtein(50);
        assertEquals(50, testGoalsA.getCurrentProtein());
        testGoalsB.addProtein(60);
        assertEquals(60, testGoalsA.getCurrentProtein());
    }

    @Test
    void testAddMultupleProtein() {
        testGoalsA.addProtein(50);
        assertEquals(50, testGoalsA.getCurrentProtein());
        testGoalsA.addProtein(60);
        assertEquals(110, testGoalsA.getCurrentProtein());
        
    }

    @Test
    void testIsGoalMet() {
        testGoalsA.setProteinGoals(200);
        testGoalsA.addProtein(100);
        testGoalsA.addProtein(100);
        assertTrue(testGoalsA.isGoalmet());
        testGoalsA.setProteinGoals(220);
        testGoalsA.addProtein(100);
        testGoalsA.addProtein(90);
        assertFalse(testGoalsA.isGoalmet());
        
    }




}
