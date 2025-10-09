package model;

public class Goals {
    private String goals;
    private int weeklyCalorieLimit;
    private int proteinGoals;
    private int currentCalories;
    private int currentProtein;

/*
 * REQUIRES: Goals need to have non-zero string length.
 * EFFECTS: Constructs the user goals for exercise and nutrition.
 */
    public Goals(String goals) {
        this.goals = goals;
    }

    public void setGoals(String newGoals) {

    }

    public String getGoals() {
        return goals;
    }

    public void setWeeklyCalorieLimit(int limit) {
    }

    public void setProteinGoals(int grams) {
    }

/*
 * MODIFIES: this
 * EFFECTS: adds the protein amount to the current protein level, 
 * updating the current protein intake amount.
 */
    public void addProtein (int amount) {
    }

/*
 * REQUIRES: currentCalories > 0, weeklyCalorieLimit > 0, currentProtein > 0, 
 * protein Goals > 0.
 * EFFECTS: Checks if the goals are met, produce true of a goal is met, if a goal is not met, produce false.
 */
    public boolean isGoalmet() {
        return false;
    }

}

