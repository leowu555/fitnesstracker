package persistence;

import model.Goals;
import model.Workout;
import model.WorkoutList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads the workout list from JSON data stored in file
// I referred the code in JsonSerializationDemo file
public class JsonReader {
    private String source;

    //EFFECTS: constructs a reader to read from source file
    public JsonReader(String source) {
        //stub;
    }

    // EFFECTS: reads workout list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkoutList read() throws IOException {
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return null;
    }

    // EFFECTS: parses workout list from JSON object and returns it
    private WorkoutList parseWorkoutList(JSONObject jsonObject) {
        return null;
    }

    // MODIFIES: wl
    // EFFECTS: parses workouts from JSON object and adds them to workout list
    private void addWorkouts(WorkoutList wl, JSONObject jsonObject) {
        // stub;
    }

    
    // MODIFIES: w
    // EFFECTS: parses workout from JSON object and adds it to workout list
    private void addWorkout(Workout w, JSONObject jsonObject) {
        // stub;
    }
}
