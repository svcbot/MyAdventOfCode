package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PuzzleInput {

    public static List<String> getInput(String resourcePath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(PuzzleInput.class.getClassLoader().getResourceAsStream(resourcePath))))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Integer> getDay1Input() {
        List<String> rawInput = getInput("./input/day1.txt");
        return Objects.requireNonNull(rawInput).stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public static List<Integer> getDay2Input() {
        List<String> rawInput = getInput("./input/day2.txt");
        return Objects.requireNonNull(rawInput).stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public static List<String> getDay3Input() {
        return getInput("./input/day3.txt");
    }

    public static List<Integer> getDay4Input() {
        List<String> rawInput = getInput("./input/day4.txt");
        return Objects.requireNonNull(rawInput).stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public static String getDay5Input() {
        List<String> rawInput = getInput("./input/day5.txt");
        return Objects.requireNonNull(rawInput).get(0);

    }

    public static List<String> getDay6Input() {
        return getInput("./input/day6.txt");
    }

    public static String getDay7Input() {
        List<String> rawInput = getInput("./input/day7.txt");
        return Objects.requireNonNull(rawInput).get(0);
    }
}
