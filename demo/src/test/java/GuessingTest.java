import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import com.example.ClassicGuessing;

public class GuessingTest {
    
    @Test
    public void no_values_out_of_ranges() throws IOException {
        
        String t1 = "3\n30\n10\n10\n10\n10\n10\n10\n10\n10\n10\n";
        ClassicGuessing.run(t1);
        assertTrue(ClassicGuessing.getAnswer() < 101 && ClassicGuessing.getAnswer() > 0);
        assertFalse(ClassicGuessing.getAnswer() < 101 && ClassicGuessing.getAnswer() > 0);
    }
}
