import day3.Day3;
import day3.Orientation;
import day3.Point;
import day3.WireSection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
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
   public void testFindIntersections() {
      List<WireSection> wire1 = new ArrayList<WireSection>();
      List<WireSection> wire2 = new ArrayList<WireSection>();

      wire1.add(new WireSection(25,50,75,50));
      wire2.add(new WireSection(50,25,50,75));
      assertEquals("Upper right quadrant", new Point(50,50), findIntersections(wire1, wire2).get(0));
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(25,-50,75,-50));
      wire2.add(new WireSection(50,-25,50,-75));
      assertEquals("Lower right quadrant", new Point(50,-50), findIntersections(wire1, wire2).get(0));
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(-25,50,-75,50));
      wire2.add(new WireSection(-50,25,-50,75));
      assertEquals("Upper left quadrant", new Point(-50,50), findIntersections(wire1, wire2).get(0));
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(-25,-50,-75,-50));
      wire2.add(new WireSection(-50,-25,-50,-75));
      assertEquals("Lower left quadrant", new Point(-50,-50), findIntersections(wire1, wire2).get(0));
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(50,25,50,75));
      wire2.add(new WireSection(25,50,75,50));
      assertEquals("Upper right quadrant", new Point(50,50), findIntersections(wire1, wire2).get(0));
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(50,-25,50,-75));
      wire2.add(new WireSection(25,-50,75,-50));
      assertEquals("Lower right quadrant", new Point(50,-50), findIntersections(wire1, wire2).get(0));
      wire2.clear();
      wire1.clear();

      wire1.add(new WireSection(-50,25,-50,75));
      wire2.add(new WireSection(-25,50,-75,50));
      assertEquals("Upper left quadrant", new Point(-50,50), findIntersections(wire1, wire2).get(0));
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(-50,-25,-50,-75));
      wire2.add(new WireSection(-25,-50,-75,-50));
      assertEquals("Lower left quadrant", new Point(-50,-50), findIntersections(wire1, wire2).get(0));
      wire1.clear();
      wire2.clear();
   }

   @Test
   public void testFindClosestIntersection() {
      List<Point> intersections = new ArrayList<>();
      intersections.add(new Point(10, 10));
      intersections.add(new Point(-15, 5));
      intersections.add(new Point(-5, -5));

      assertEquals("Expected closest intersection", new Point(-5,-5), findClosestIntersection(intersections).get());
      Collections.reverse(intersections);
      assertEquals("Expected closest intersection", new Point(-5,-5), findClosestIntersection(intersections).get());
   }

   @Test
   public void testParseWire() {
      String testWireCode = "R75,D30,R83,U83";
      WireSection[] expected = {
              new WireSection(0,0,75,0),
              new WireSection(75,0,75,-30),
              new WireSection(75,-30,158,-30),
              new WireSection(158,-30,158,53)
      };

      assertArrayEquals("Test wirecode parsing", expected, parseWire(testWireCode).toArray());
   }

   @Test
   public void testWireSection() {
      WireSection wireSection1 = new WireSection(new Point(-1, -1), new Point(-99, -1));
      WireSection wireSection2 = new WireSection(new Point(-11, -11), new Point(-11, -1));
      assertEquals("Check orientation: ", Orientation.horizontal, wireSection1.orientation);
      assertEquals("Check orientation: ", Orientation.vertical, wireSection2.orientation);
   }

}
