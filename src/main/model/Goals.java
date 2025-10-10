package model;

public class Goals {
    private String goals;
    private int proteinGoals;
    private int currentProtein;

    /*
     * REQUIRES: Goals need to have non-zero string length.
     * EFFECTS: Constructs the user goals for exercise and nutrition.
     */
    public Goals(String goals) {
        this.goals = goals;
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

}
