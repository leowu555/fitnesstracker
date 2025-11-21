package ui;

import model.Workout;
import model.WorkoutList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FitnessAppGUI extends JFrame implements ActionListener{
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

    // EFFECTS: Constructs GUI and initialized the data from JSON and set up the structure
    public FitnessAppGUI() {
        super("Fitness Tracker");
        workoutList = new WorkoutList("My Workouts");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        setupFrame();
        setupPanels();
        setVisible(true);
    }
    
    // EFFECTS: Initialized the main JFrame
    private void setupFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }

    //EFFECTS: Initializes all panels
    private void setupPanels() {
        setupWorkoutPanel();
        setupButtonPanel();
        setupImagePanel();
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
        JPanel buttonPanel = new JPanel (new GridLayout(1, 5));
        addButton = new JButton("Add Workout");
        filterButton = new JButton("Show Completed");
        showButton = new JButton("View All");
        completeButton = new JButton ("Mark as Complete");
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        addButton.addActionListener(this);
        filterButton.addActionListener(this);
        showButton.addActionListener(this);
        completeButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        buttonPanel.add(addButton);
        buttonPanel.add(filterButton);
        buttonPanel.add(showButton);
        buttonPanel.add(completeButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        add(buttonPanel, BorderLayout.NORTH);
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
        }
    }
    
    // MODIFIES: this
    // EFFECTS: Handles users to add workout to the list
    private void handleAddWorkout() {
    }

    // MODIFIES: this
    // EFFECTS: Marks selected workouts as complete if the workout is valid
    private void markWorkoutAsCompleted() {
    }

    // MODIFIES: this
    // EFFECTS: Shows only workouts that marked as complete
    private void showCompletedWorkouts() {
    }

    // MODIFIES: this
    // EFFECTS: Refreshes the list of workouts with the required minutes. 
    // if completed, 
    private void refreshWorkoutList() {
    }

    // EFFECTS: Saves workout list to file
    private void saveWorkoutList() {
    }

    // MODIFIES: this 
    // EFFECTS: Loads workout list from the file after saving file
    private void loadWorkoutList() {
    }

    // EFFECTS: Launches the Fitness App application
    public static void main (String[] args) {
        new FitnessAppGUI();
    }
}
