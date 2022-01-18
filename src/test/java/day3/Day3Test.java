package day3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static day3.Day3.*;
import static org.junit.jupiter.api.Assertions.*;

public class Day3Test {

   @Test
   void testStage1() {
      assertEquals(159, Day3.solveStage1("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83"), "Test 1: ");
      assertEquals(135, Day3.solveStage1("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"), "Test 2: ");
   }

   @Test
   void testFindIntersections() {
      List<WireSection> wire1 = new ArrayList<>();
      List<WireSection> wire2 = new ArrayList<>();

      wire1.add(new WireSection(25,50,75,50));
      wire2.add(new WireSection(50,25,50,75));
      assertEquals(new Point(50,50), findIntersections(wire1, wire2).get(0), "Upper right quadrant");
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(25,-50,75,-50));
      wire2.add(new WireSection(50,-25,50,-75));
      assertEquals(new Point(50,-50), findIntersections(wire1, wire2).get(0), "Lower right quadrant");
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(-25,50,-75,50));
      wire2.add(new WireSection(-50,25,-50,75));
      assertEquals(new Point(-50,50), findIntersections(wire1, wire2).get(0), "Upper left quadrant");
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(-25,-50,-75,-50));
      wire2.add(new WireSection(-50,-25,-50,-75));
      assertEquals(new Point(-50,-50), findIntersections(wire1, wire2).get(0), "Lower left quadrant");
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(50,25,50,75));
      wire2.add(new WireSection(25,50,75,50));
      assertEquals(new Point(50,50), findIntersections(wire1, wire2).get(0), "Upper right quadrant");
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(50,-25,50,-75));
      wire2.add(new WireSection(25,-50,75,-50));
      assertEquals(new Point(50,-50), findIntersections(wire1, wire2).get(0), "Lower right quadrant");
      wire2.clear();
      wire1.clear();

      wire1.add(new WireSection(-50,25,-50,75));
      wire2.add(new WireSection(-25,50,-75,50));
      assertEquals(new Point(-50,50), findIntersections(wire1, wire2).get(0), "Upper left quadrant");
      wire1.clear();
      wire2.clear();

      wire1.add(new WireSection(-50,-25,-50,-75));
      wire2.add(new WireSection(-25,-50,-75,-50));
      assertEquals(new Point(-50,-50), findIntersections(wire1, wire2).get(0), "Lower left quadrant");
      wire1.clear();
      wire2.clear();
   }

   @Test
   void testFindClosestIntersection() {
      List<Point> intersections = new ArrayList<>();
      intersections.add(new Point(10, 10));
      intersections.add(new Point(-15, 5));
      intersections.add(new Point(-5, -5));

      assertEquals(new Point(-5,-5), findClosestIntersection(intersections).get(), "Expected closest intersection");
      Collections.reverse(intersections);
      assertEquals(new Point(-5,-5), findClosestIntersection(intersections).get(), "Expected closest intersection");
   }

   @Test
   void testParseWire() {
      String testWireCode = "R75,D30,R83,U83";
      WireSection[] expected = {
              new WireSection(0,0,75,0),
              new WireSection(75,0,75,-30),
              new WireSection(75,-30,158,-30),
              new WireSection(158,-30,158,53)
      };

      assertArrayEquals(expected, parseWire(testWireCode).toArray(), "Test wirecode parsing");
   }

   @Test
   void testWireSection() {

      // Test orientation
      WireSection wireSection1 = new WireSection(new Point(-1, -1), new Point(-99, -1));
      WireSection wireSection2 = new WireSection(new Point(-11, -11), new Point(-11, -1));
      assertEquals(Orientation.horizontal, wireSection1.orientation, "Check orientation: ");
      assertEquals(Orientation.vertical, wireSection2.orientation, "Check orientation: ");

      // Test contains
      WireSection wireSection3 = new WireSection(10, 10, 20, 10);
      assertTrue(wireSection3.contains(new Point(15, 10)), "Test positive contains 1");
      assertEquals(10, wireSection3.length, "Test expected length");

      WireSection wireSection4 = new WireSection(10, 10, 10, 20);
      assertTrue(wireSection4.contains(new Point(10, 15)), "Test positive contains 2");
      assertEquals(10, wireSection4.length, "Test expected length");

      WireSection wireSection5 = new WireSection(-10, -10, -20, -10);
      assertTrue(wireSection5.contains(new Point(-15, -10)), "Test positive contains 3");
      assertEquals(10, wireSection5.length, "Test expected length");

      WireSection wireSection6 = new WireSection(-10, -10, -10, -20);
      assertTrue(wireSection6.contains(new Point(-10, -15)), "Test positive contains 4");
      assertEquals(10, wireSection6.length,"Test expected length");

      WireSection wireSection7 = new WireSection(-10, -10, -20, -10);
      assertFalse(wireSection7.contains(new Point()), "Test negative contains 5");
      assertEquals(10, wireSection7.length, "Test expected length");

      WireSection wireSection8 = new WireSection(-10, -10, -10, -20);
      assertFalse(wireSection8.contains(new Point(-9, -19)), "Test negative contains 5");
   }

   @Test
   void testFindFastestIntersection() {
      String testWireCode1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
      String testWireCode2 = "U62,R66,U55,R34,D71,R55,D58,R83";
      List<WireSection> wire1 = parseWire(testWireCode1);
      List<WireSection> wire2 = parseWire(testWireCode2);
      List<Point> intersections = findIntersections(wire1, wire2);
      assertEquals(
              610,
              findFastestCombinedPath(intersections, wire1, wire2),
              "Test fastest intersection 1:"
      );

      testWireCode1 = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51";
      testWireCode2 = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7";
      wire1 = parseWire(testWireCode1);
      wire2 = parseWire(testWireCode2);
      intersections = findIntersections(wire1, wire2);
      assertEquals(
              410,
              findFastestCombinedPath(intersections, wire1, wire2),
              "Test fastest intersection 2:"
      );

   }

   @Test
   void testDistanceTo() {
      Point point1 = new Point();
      assertEquals(10, point1.distanceTo(new Point(10, 0)), "Test distance to 1");

      Point point2 = new Point(10, 0);
      assertEquals(point2.distanceTo(new Point(10, 10)), 10, "Test distance to 2");

      Point point3 = new Point(-10, -10);
      assertEquals(10, point3.distanceTo(new Point(-10, -20)), "Test distance to 3");

      Point point4 = new Point(-10, -10);
      assertEquals(10, point4.distanceTo(new Point(-20, -10)), "Test distance to 4");

   }

}
