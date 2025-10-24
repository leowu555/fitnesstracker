package persistence;

import model.Workout;
import model.WorkoutList;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport
class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WorkoutList wl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkoutList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkoutList.json");
        try {
            WorkoutList wl = reader.read();
            assertEquals("My Workouts to Complete", wl.getListName());
            assertEquals(0, wl.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkoutList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkoutList.json");
        try {
            WorkoutList wl = reader.read();
            assertEquals("My Workouts to Complete", wl.getListName());
            List<Workout> workouts = wl.getWorkoutList();
            assertEquals(3, workouts.size());
            checkWorkout("Push-up", 30, false, workouts.get(0));
            checkWorkout("Running", 20, false, workouts.get(1));
            checkWorkout("Sit-up", 15, false, workouts.get(2));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
