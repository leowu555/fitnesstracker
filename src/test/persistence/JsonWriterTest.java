package persistence;

import model.Workout;
import model.WorkoutList;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport
class JsonWriterTest extends JsonTest {
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkoutList() {
        try {
            WorkoutList wl = new WorkoutList("My Workouts to Complete");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkoutList.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkoutList.json");
            wl = reader.read();
            assertEquals("My Workouts to Complete", wl.getListName());
            assertEquals(0, wl.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkoutList() {
        try {
            WorkoutList wl = new WorkoutList("My Workouts to Complete");
            wl.addWorkout(new Workout("push", 20));
            wl.addWorkout(new Workout("squat", 15));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkoutList.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkoutList.json");
            wl = reader.read();
            assertEquals("My Workouts to Complete", wl.getListName());
            List<Workout> workouts = wl.getWorkoutList();
            assertEquals(2, workouts.size());
            checkWorkout("push", 30, false, workouts.get(0));
            checkWorkout("squat", 30, false, workouts.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}