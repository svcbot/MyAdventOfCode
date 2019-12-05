import day3.Day3;
import day3.Point;
import day3.WireSection;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static day3.Day3.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestDay3 {
   @Test
   public void testStage1() {
      assertEquals("Test 1: ", 159, Day3.solveStage1("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83"));
      assertEquals("Test 2: ", 135, Day3.solveStage1("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"));
   }

   @Test
   public void testFindIntersection() {
      List<WireSection> wire1 = new ArrayList<WireSection>();
      List<WireSection> wire2 = new ArrayList<WireSection>();

      wire1.add(new WireSection(new Point(0,2), new Point(2,2)));
      wire2.add(new WireSection(new Point(1,0), new Point(1, 3)));
      wire1.add((new WireSection(new Point(-2, -4), new Point(0, -4))));
      wire2.add((new WireSection(new Point(-1,-2), new Point(-1,-6))));
      Point[] expected = {new Point(1,2), new Point(-1,-4)};
      assertArrayEquals("Expected intersections", expected, findIntersections(wire1, wire2).toArray());
   }

   @Test
   public void testFindClosestIntersection() {
      List<Point> intersections = new ArrayList<>();
      intersections.add(new Point(10, 10));
      intersections.add(new Point(-5, -5));

      assertEquals("Expected closest intersection", new Point(-5,-5), findClosestIntersection(intersections).get());
   }

   @Test
   public void testParseWire() {
      String testWireCode = "R75,D30,R83,U83";
      WireSection[] expected = {
              new WireSection(new Point(0, 0), new Point(75, 0)),
              new WireSection(new Point(75, 0), new Point(75, -30)),
              new WireSection(new Point(75, -30), new Point(158, -30)),
              new WireSection(new Point(158, -30), new Point(158, 53))
      };

      assertArrayEquals("Test wirecode parsing", expected, parseWire(testWireCode).toArray());
   }

}
