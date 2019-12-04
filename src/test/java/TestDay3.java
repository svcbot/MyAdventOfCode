import day3.Day3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay3 {
   @Test
   public void testStage1() {
      assertEquals("Test 1: ", 159, Day3.solveStage1("R75,D30,R83,U83,L12,D49,R71,U7,L72","U62,R66,U55,R34,D71,R55,D58,R83"));
      assertEquals("Test 2: ", 135, Day3.solveStage1("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51","U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"));
   }
}
