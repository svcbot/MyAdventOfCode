package day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {

    @Test
    void testStage1() {
        assertEquals(Day1.computeFuelForMass(12), 2, "Test fuel for 12 mass: ");
        assertEquals(Day1.computeFuelForMass(1969), 654, "Test fuel for 1969 mass: ");
        assertEquals(Day1.computeFuelForMass(100756), 33583, "Test fuel for 100756 mass: ");
    }

    @Test
    void testStage2() {
        assertEquals(Day1.computeFuelTotalMass(14), 2, "Test fuel for 12 mass: ");
        assertEquals(Day1.computeFuelTotalMass(1969), 966, "Test fuel for 1969 mass: ");
        assertEquals(Day1.computeFuelTotalMass(100756), 50346, "Test fuel for 100756 mass: ");
    }
}
