package model;

import java.util.ArrayList;
import java.util.List;

// Represents a goal that the user can set for their workout and nutrition.
public class Goals {
    private String goals;
    private int proteinGoals;
    private int currentProtein;
    private List<Integer> dailyProtein;

    /*
     * REQUIRES: Goals need to have non-zero positive string length.
     * EFFECTS: Constructs the user goals for exercise and nutrition.
     */
    public Goals(String goals) {
        this.goals = goals;
        this.dailyProtein = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            dailyProtein.add(0);
        }
    }

    public void setGoals(String newGoals) {
        this.goals = newGoals;
    }

    public String getGoals() {
        return goals;
    }

    public int getCurrentProtein() {
        return currentProtein;
    }

    public void setProteinGoals(int grams) {
        this.proteinGoals = grams;
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds the protein amount to the current protein level,
     * updating the current protein intake amount.
     */
    public void addProtein(int amount) {
        this.currentProtein += amount;
    }

    public void resetProtein() {
        for (int i = 0; i < 7; i++) {
            dailyProtein.set(i, 0);
        }
    }

    /*
     * REQUIRES: currentProtein > 0, proteinGoals > 0.
     * EFFECTS: Checks if the goals are met, produce true of a goal is met, if a
     * goal is not met, produce false.
     */
    public boolean isGoalmet() {
        if (currentProtein >= proteinGoals) {
            return true;
        }
        return false;
    }

    public void logProteinForDay(int dayIndex, int grams) {
        int updated = dailyProtein.get(dayIndex) + grams;
        dailyProtein.set(dayIndex, updated);
        currentProtein += grams;
    }

    public List<Integer> getDailyProtein() {
        return new ArrayList<>(dailyProtein);
    }
}
