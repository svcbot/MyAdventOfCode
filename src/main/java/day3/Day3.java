package day3;

import Util.PuzzleInput;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Day3 {

    static Logger LOG = Logger.getLogger(Day3.class.toString());

    public static int solveStage1() {
        List<String> puzzleInput = PuzzleInput.getDay3Input();
        return solveStage1(puzzleInput.get(0), puzzleInput.get(1));
    }

    public static int solveStage1(String wireCode1, String wireCode2) {
        List<WireSection> wire1 = parseWire(wireCode1);
        List<WireSection> wire2 = parseWire(wireCode2);
        List<Point> intersections = findIntersections(wire1, wire2);
        Point closestIntersection = findClosestIntersection(intersections).get();
        int distance = distanceOnGrid(closestIntersection);
        LOG.info("Day 3 Stage 1 solution is " + distance);
        return distance;
    }

    public static Optional<Point> findClosestIntersection(List<Point> intersections) {
        return intersections.stream().filter(w -> w.x != 0 && w.y != 0).min(Comparator.comparingInt(point -> abs(point.x) + abs(point.y)));
    }

    public static List<Point> findIntersections(List<WireSection> wire1, List<WireSection> wire2) {
        List<Point> intersections = new ArrayList<>();
        wire2.forEach(wireSection -> {
            wire1.forEach(wireSection2 -> {
                Optional<Point> intersectionResult = wireSection2.intersect(wireSection);
                intersectionResult.ifPresent(e -> {
                    intersections.add(e);
                    //LOG.info("An intersection " + e + " was found between " + wireSection + " and " + wireSection2);
                });
            });
        });

        return intersections.stream().filter(i -> !i.equals(new Point())).collect(Collectors.toList());
    }

    public static int solveStage2() {
        List<String> puzzleInput = PuzzleInput.getDay3Input();
        return solveStage2(puzzleInput.get(0), puzzleInput.get(1));
    }

    public static int solveStage2(String wireCode1, String wireCode2) {
        List<WireSection> wire1 = parseWire(wireCode1);
        List<WireSection> wire2 = parseWire(wireCode2);
        List<Point> intersections = findIntersections(wire1, wire2);
        int fastestCombinedPath = findFastestCombinedPath(intersections, wire1, wire2);
        LOG.info("Day3 stage 2 solution is " + fastestCombinedPath);
        return fastestCombinedPath;
    }

    public static int findFastestCombinedPath(List<Point> intersections, List<WireSection> wire1, List<WireSection> wire2) {
        return intersections.stream().map(i -> {
            int wire1PathLength = findWirePath(i, wire1);
            int wire2PathLength = findWirePath(i, wire2);
            return wire1PathLength + wire2PathLength;
        }).min(Comparator.comparing(Integer::valueOf)).orElse(-1);
    }

    private static int findWirePath(Point i, List<WireSection> wire) {
        int pathLength = 0;

        for (WireSection wireSection : wire) {
            if (wireSection.contains(i)) {
                pathLength += wireSection.start.distanceTo(i);
                return pathLength;
            } else {
                pathLength += wireSection.length;
            }
        }

        return pathLength;
    }


    public static List<WireSection> parseWire(String wireCode) {
        Point startingPoint = new Point();
        List<WireSection> wireSectionList = new ArrayList<>();

        List<String> encodedWireSectionList = Arrays.stream(wireCode.split(",")).collect(Collectors.toList());
        for (String encodedWireSection : encodedWireSectionList) {
            WireSection wireSection = new WireSection(startingPoint, encodedWireSection);
            wireSectionList.add(wireSection);
            startingPoint = wireSection.end;
        }

        return wireSectionList;
    }

    public static int distanceOnGrid(Point point) {
        return Math.abs(point.x) + Math.abs(point.y);
    }


}
