
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.example.ClassicGuessing;
import com.example.DifficultyGuessing;
import com.example.TimedGuessing;

// TESTS ARE INCOMPLETE

public class GuessingTest {
    
    // Making sure that the correct answer is within the given range
    // set by difficulty or general settings.
    @Test
    public void no_values_out_of_ranges() {
        
        // TESTING CLASSIC MODE
        for(int i = 0; i < 100; i++) {
            String t1 = "3\n0\n";
            int answer = ClassicGuessing.run(t1);
            Assertions.assertTrue(answer < 101 && answer > 0);
        }

        // TESTING DIFFICULTY MODE
        // Easy Mode
        for(int i = 0; i < 100; i++) {
            String t1 = "1\n0\n";
            int answer = DifficultyGuessing.run(t1);
            Assertions.assertTrue(answer < 51 && answer > 0);

        }
        // Medium Mode
        for(int i = 0; i < 100; i++) {
            String t1 = "2\n0\n";
            int answer = DifficultyGuessing.run(t1);
            Assertions.assertTrue(answer < 101 && answer > 0);
        }
        // Hard Mode
        for(int i = 0; i < 100; i++) {
            String t1 = "3\n0\n";
            int answer = DifficultyGuessing.run(t1);
            Assertions.assertTrue(answer < 501 && answer > 0);
        }

        // TESTING TIMED MODE
        // Easy Mode
        for(int i = 0; i < 100; i++) {
            String t1 = "1\n0\n";
            int answer = TimedGuessing.run(t1);
            Assertions.assertTrue(answer < 51 && answer > 0);

        }
        // Medium Mode
        for(int i = 0; i < 100; i++) {
            String t1 = "2\n0\n";
            int answer = TimedGuessing.run(t1);
            Assertions.assertTrue(answer < 101 && answer > 0);
        }
        // Hard Mode
        for(int i = 0; i < 100; i++) {
            String t1 = "3\n0\n";
            int answer = TimedGuessing.run(t1);
            Assertions.assertTrue(answer < 501 && answer > 0);
        }

    }
}
