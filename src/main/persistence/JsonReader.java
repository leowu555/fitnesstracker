package persistence;

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

    // EFFECTS: constructs a reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workout list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkoutList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkoutList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workout list from JSON object and returns it
    private WorkoutList parseWorkoutList(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        WorkoutList wl = new WorkoutList(name);
        addWorkouts(wl, jsonObject);
        return wl;
    }

    // MODIFIES: wl
    // EFFECTS: parses workouts from JSON object and adds them to workout list
    private void addWorkouts(WorkoutList wl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("WorkoutList");
        for (Object json : jsonArray) {
            JSONObject nextWorkout = (JSONObject) json;
            addWorkout(wl, nextWorkout);
        }
    }

    // MODIFIES: wl
    // EFFECTS: parses workout from JSON object and adds it to workout list
    private void addWorkout(WorkoutList wl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int minsNeeded = jsonObject.getInt("minsNeeded");
        boolean hasCompleted = jsonObject.getBoolean("hasCompleted");
        Workout workout = new Workout(name, minsNeeded);
        if (hasCompleted) {
            workout.markComplete();
        }
        wl.addWorkout(workout);
    }
}
