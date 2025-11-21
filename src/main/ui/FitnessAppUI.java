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

public class FitnessAppUI extends JFrame implements ActionListener{
    private static final String JSON_STORE = "data/workoutlist.json";

    public FitnessAppUI() {
        super("Fitness Tracker");
        workoutList = new WorkoutList("My Workouts");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        setupFrame();
        setupPanels();
        setVisible(true);
    }
    
    private void setupFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }

    private void setupPanels() {
        setupWorkoutPanel();
        setupButtonPanel();
        setupImagePanel();
    }

    private void setupWorkoutPanel() {
    }

    private void setupButtonPanel() {
    }

    private void setupImagePanel() {
    }

    public static void main (String[] args) {
        new FitnessAppUI();
    }
}
