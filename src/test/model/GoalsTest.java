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
        testGoalsB = new Goals("Take 150 grams of protein");
    }

    @Test
    void testConstructor() {
        assertEquals("bench 225 pounds", testGoalsA.getGoals());
        assertEquals("Take 150 grams of protein", testGoalsB.getGoals());
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
        testGoalsB.addProtein(50);
        assertEquals(50, testGoalsB.getCurrentProtein());
    }

    @Test
    void testAddMultupleProtein() {
        testGoalsB.addProtein(50);
        assertEquals(50, testGoalsB.getCurrentProtein());
        testGoalsB.addProtein(60);
        assertEquals(110, testGoalsB.getCurrentProtein());

    }

    @Test
    void testIsGoalMet() {
        testGoalsB.setProteinGoals(200);
        testGoalsB.addProtein(100);
        testGoalsB.getCurrentProtein();
        assertFalse(testGoalsB.isGoalmet());
        testGoalsB.setProteinGoals(250);
        testGoalsB.addProtein(150);
        testGoalsB.getCurrentProtein();
        assertTrue(testGoalsB.isGoalmet());
    }

}
