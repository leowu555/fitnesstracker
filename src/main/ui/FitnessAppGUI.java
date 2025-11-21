package ui;

import model.Workout;
import model.WorkoutList;
import model.Goals;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FitnessAppGUI extends JFrame implements ActionListener {
    private static final String JSON_STORE = "data/workoutlist.json";
    private WorkoutList workoutList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private DefaultListModel<String> workoutListModel;
    private JList<String> workoutJList;
    private JLabel label;

    private JButton addButton;
    private JButton filterButton;
    private JButton saveButton;
    private JButton completeButton;
    private JButton loadButton;
    private JButton showButton;
    private JButton resetWeekButton;

    private Goals goals;
    private ProteinGraphPanel proteinPanel;
    private JButton setGoalButton;
    private JButton logProteinButton;
    private JButton viewGraph;

    // EFFECTS: Constructs GUI and initialized the data from JSON and set up the
    // structure
    public FitnessAppGUI() {
        super("Fitness Tracker");
        workoutList = new WorkoutList("My Workouts");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        setupFrame();
        setupPanels();
        setVisible(true);

        goals = new Goals("No goals set yet");
    }

    // EFFECTS: Initialized the main JFrame
    private void setupFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }

    // EFFECTS: Initializes all panels
    private void setupPanels() {
        setupWorkoutPanel();
        setupButtonPanel();
        setupImagePanel();
        setupGraphPanel();
    }

    // MODIFIES: this
    // EFFECTS: Initializes and adds the workout to the panel
    private void setupWorkoutPanel() {
        workoutListModel = new DefaultListModel<>();
        workoutJList = new JList<>(workoutListModel);

        JScrollPane scrollPane = new JScrollPane(workoutJList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Workouts In Your List"));
        add(scrollPane, BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECTS: Initializes buttons and their listeners
    private void setupButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));
        setupMainButtons(buttonPanel);
        setupProteinButtons(buttonPanel);
        add(buttonPanel, BorderLayout.NORTH);
    }

    // MODIFIES: panel
    // EFFECTS: Initializes the main workout related buttons and set their listeners
    // and add to the panel
    private void setupMainButtons(JPanel panel) {
        addButton = new JButton("Add Workout");
        filterButton = new JButton("Show Completed");
        showButton = new JButton("View All");
        completeButton = new JButton("Mark as Complete");
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");

        addButton.addActionListener(this);
        filterButton.addActionListener(this);
        showButton.addActionListener(this);
        completeButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);

        panel.add(addButton);
        panel.add(filterButton);
        panel.add(showButton);
        panel.add(completeButton);
        panel.add(saveButton);
        panel.add(loadButton);
    }

    // MODIFIES: panel
    // EFFECTS: Initializes the main protein related button and set their listeners
    // and add to the panel
    private void setupProteinButtons(JPanel panel) {
        setGoalButton = new JButton("Set Protein Goal");
        logProteinButton = new JButton("Log Protein");
        viewGraph = new JButton("View Graph");
        resetWeekButton = new JButton("Reset Week");

        setGoalButton.addActionListener(this);
        logProteinButton.addActionListener(this);
        viewGraph.addActionListener(this);
        resetWeekButton.addActionListener(this);

        panel.add(setGoalButton);
        panel.add(logProteinButton);
        panel.add(viewGraph);
        panel.add(resetWeekButton);
    }

    // MODIFIES: this
    // EFFECTS: Sets up the image for the panel
    private void setupImagePanel() {
        JPanel img = new JPanel();
        label = new JLabel();

        img.add(label);
        img.setBorder(BorderFactory.createTitledBorder("Visual Component"));
        add(img, BorderLayout.SOUTH);
    }

    // MODIFIES: this
    // EFFECTS: Sets up the image for the panel
    private void setupGraphPanel() {
        proteinPanel = new ProteinGraphPanel();
        proteinPanel.setPreferredSize(new Dimension(600, 200));
        proteinPanel.setBorder(BorderFactory.createTitledBorder("Weekly Protein Intake Graph"));
        add(proteinPanel, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == addButton) {
            handleAddWorkout();
        } else if (a.getSource() == filterButton) {
            showCompletedWorkouts();
        } else if (a.getSource() == showButton) {
            refreshWorkoutList();
        } else if (a.getSource() == completeButton) {
            markWorkoutAsCompleted();
        } else if (a.getSource() == saveButton) {
            saveWorkoutList();
        } else if (a.getSource() == loadButton) {
            loadWorkoutList();
        } else {
            handleProteinActions(a.getSource());
        }
    }

    // MODIFIES: this
    // EFFECTS: Handles actions related to protein tracking buttons
    // and checks all the cases with the appropirate handler method
    private void handleProteinActions(Object protein) {
        if (protein == setGoalButton) {
            handleSetProteinGoal();
        } else if (protein == logProteinButton) {
            handleLogProtein();
        } else if (protein == viewGraph) {
            proteinPanel.setDailyProtein(goals.getDailyProtein());
        } else if (protein == resetWeekButton) {
            handleResetWeek();
        }
    }

    // MODIFIES: goals
    // EFFECTS: handles the user's goals and sets it if the input is valid
    private void handleSetProteinGoal() {
        String input = JOptionPane.showInputDialog(this, "Set weekly protein goal (grams):");
        if (input != null && input.matches("\\d+")) {
            goals.setProteinGoals(Integer.parseInt(input));
            JOptionPane.showMessageDialog(this, "Goal has been set!");
        }
    }

    // MODIFIES: goals
    // EFFECTS: handles the protein that users log in and logs to the correct day
    private void handleLogProtein() {
        String day = JOptionPane.showInputDialog(this, "Enter day of week (0=Sun, 6=Sat):");
        String grams = JOptionPane.showInputDialog(this, "Enter grams of protein consumed:");
        if (day != null && grams != null && day.matches("[0-6]") && grams.matches("\\d+")) {
            int dayIndex = Integer.parseInt(day);
            int proteinAmount = Integer.parseInt(grams);
            goals.logProteinForDay(dayIndex, proteinAmount);
            JOptionPane.showMessageDialog(this, "Protein logged!");
        }
    }

    // MODIFIES: goals, proteinPanel
    // EFFECTS: Asks the user to reset the protein graph,
    // clears the graph and data and updates the panel if the user is confirmed
    private void handleResetWeek() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to reset this week's protein log?",
                "Confirm Reset", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            goals.resetProtein();
            proteinPanel.setDailyProtein(goals.getDailyProtein());
            JOptionPane.showMessageDialog(this, "Protein data has been reset for the new week.");
        }
    }

    // MODIFIES: this
    // EFFECTS: Handles users to add workout to the list
    private void handleAddWorkout() {
        String name = JOptionPane.showInputDialog(this, "Enter Workout Name: ");
        if (name == null || name.trim().isEmpty()) {
            return;
        }

        String duration = JOptionPane.showInputDialog(this, "Enter Duration (in mins): ");
        if (duration == null || !duration.matches("\\d+")) {
            return;
        }

        int mins = Integer.parseInt(duration);
        Workout w = new Workout(name, mins);
        workoutList.addWorkout(w);

        refreshWorkoutList();
    }

    // MODIFIES: this
    // EFFECTS: Marks selected workouts as complete if the workout is valid
    private void markWorkoutAsCompleted() {
        int index = workoutJList.getSelectedIndex();
        if (index != -1 && index < workoutList.getWorkoutList().size()) {
            Workout selected = workoutList.getWorkoutList().get(index);
            selected.markComplete();
            refreshWorkoutList();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a workout to mark as complete.");
        }
    }

    // MODIFIES: this
    // EFFECTS: Shows only workouts that marked as complete
    private void showCompletedWorkouts() {
        workoutListModel.clear();

        for (Workout w : workoutList.getWorkoutList()) {
            if (w.isCompleted()) {
                workoutListModel.addElement(w.getName() + " (" + w.getDuration() + "mins, completed)");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Refreshes the list of workouts with the required minutes.
    // if completed,
    private void refreshWorkoutList() {
        workoutListModel.clear();

        for (Workout w : workoutList.getWorkoutList()) {
            String text = w.getName() + " (" + w.getDuration() + " mins)";
            if (w.isCompleted()) {
                text += " Completed!";
            }
            workoutListModel.addElement(text);
        }
    }

    // EFFECTS: Saves workout list to file
    private void saveWorkoutList() {
        try {
            jsonWriter.open();
            jsonWriter.write(workoutList);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this, "Saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error: Could not save file.");
        }
    }

    // MODIFIES: this
    // EFFECTS: Loads workout list from the file after saving file
    private void loadWorkoutList() {
        try {
            workoutList = jsonReader.read();
            refreshWorkoutList();
            JOptionPane.showMessageDialog(this, "Loaded from " + JSON_STORE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: Could not load file.");
        }
    }

    // EFFECTS: Launches the Fitness App application
    public static void main(String[] args) {
        new FitnessAppGUI();
    }
}
