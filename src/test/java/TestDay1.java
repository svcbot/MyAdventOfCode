import day1.Day1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay1 {

    @Test
    public void testStage1() {
        assertEquals("Test fuel for 12 mass: ", Day1.computeFuelForMass(12), 2);
        assertEquals("Test fuel for 1969 mass: ", Day1.computeFuelForMass(1969), 654);
        assertEquals("Test fuel for 100756 mass: ", Day1.computeFuelForMass(100756), 33583);
    }

    @Test
    public void testStage2() {
        assertEquals("Test fuel for 12 mass: ", Day1.computeFuelTotalMass(14), 2);
        assertEquals("Test fuel for 1969 mass: ", Day1.computeFuelTotalMass(1969), 966);
        assertEquals("Test fuel for 100756 mass: ", Day1.computeFuelTotalMass(100756), 50346);
    }
}
