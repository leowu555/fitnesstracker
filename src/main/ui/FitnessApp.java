package ui;

import model.WorkoutList;
import model.Goals;

import java.util.Scanner;
// I refered to the TellerApp to design the ui code.

public class FitnessApp {
    private Scanner input;
    private WorkoutList workoutList;
    private Goals goals;

    // EFFECTS: runs the fitness application
    public FitnessApp() {
        runFitnessApp();
    }
    // EFFECTS: Initializes the app state and repeatly displays a menu for the user
    public void runFitnessApp() {
        boolean keepGoing = true;
        String command = "";
        init();

        while (keepGoing) {
            displayMenu();
            command = input.next().toLowerCase();

            if (command.equals("x")) {
                keepGoing = false;
            } else {
                commandProcess(command);
            }
        }

        System.out.println("See you! Stay strong!");
    }

    // MODIFIES: this
    // EFFECTS: initializes the workout list and goals.
    private void init() {
        workoutList = new WorkoutList();
        goals = new Goals("Weekly workout and protein goal");
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
    }

    // EFFECTS: displays menu of the options that user can have access to
    private void displayMenu() {
        System.out.println("\nChoose from:");
        System.out.println("\ta -> Add workout");
        System.out.println("\tr -> Remove workout");
        System.out.println("\tv -> View workout list");
        System.out.println("\ts -> Set protein goal");
        System.out.println("\tl -> Log protein intake");
        System.out.println("\tc -> Check if goal met");
        System.out.println("\tx -> Leave");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void commandProcess(String command) {
        if (command.equals("a")) {
            addWorkout();
        } else if (command.equals("r")) {
            removeWorkout();
        } else if (command.equals("v")) {
            viewWorkout();
        } else if (command.equals("s")) {
            setProteinGoal();
        } else if (command.equals("l")) {
            logProteinIntake();
        } else if (command.equals("c")) {
            checkIfGoalMet();
        } else {
            System.out.println("Selection is Invalid");
        }

    }

    // MODIFIES: this
    // EFFECTS: adds a workout to the list of workouts that the user wants to
    // complete.
    private void addWorkout() {
        System.out.println("Please enter workout name: ");
        String name = input.next();
        if (!workoutList.isWorkoutInList(name)) {
            workoutList.addWorkout(name);
            System.out.println("Workout has been added:" + name);
        } else {
            System.out.println("Workout is already in the list.");
        }

    }

    // MODIFIES: this
    // EFFECTS: removes an unwanted workout or a completed workout from the list.
    private void removeWorkout() {
        System.out.println("Enter the workout name to remove: ");
        String name = input.next();
        if (workoutList.isWorkoutInList(name)) {
            workoutList.removeWorkout(name);
            System.out.println("Workout has been removed" + name);
        } else {
            System.out.println("Workout is not in list.");
        }
    }

    // EFFECTS: Shows and displays the current workout list to the user.
    private void viewWorkout() {
        System.out.println("Workouts needed to complete:");
        for (String s : workoutList.getWorkoutList()) {
            System.out.println("Workouts needed to complete:" + s);
        }
    }

    // MODIFIES: this
    // EFFECTS: Sets the user's weekly protein goal
    private void setProteinGoal() {
        System.out.println("Please enter your protein intake goal (in grams)");
        int grams = input.nextInt();
        goals.setProteinGoals(grams);
        System.out.println("Protein goals set to " + grams);
    }

    // MODIFIES: this
    // EFFECTS: Adds and logs the protein intake and check the current protein
    // intake level.
    private void logProteinIntake() {
        System.out.println("Please enter your protein intake (in grams)");
        int intake = input.nextInt();
        goals.addProtein(intake);
        System.out.println("Current protein intake: " + goals.getCurrentProtein());
    }

    // EFFECTS: Check if the goal that the user has been completed.
    private void checkIfGoalMet() {
        if (goals.isGoalmet()) {
            System.out.println("You have completed your goal!");
        } else {
            System.out.println("Keep going! You will meet your goal soon!");
        }

    }

}
