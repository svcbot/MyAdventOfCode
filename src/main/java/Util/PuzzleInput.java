package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Stream;

public class PuzzleInput {

    public static Stream<String> getInput(String resourcePath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(PuzzleInput.class.getClassLoader().getResourceAsStream(resourcePath))))) {
            return reader.lines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }

    public static Stream<Integer> getDay1Input() {
        Stream<String> rawInput = getInput("AoC2019/input/day1.txt");
        return rawInput.map(Integer::valueOf);
    }

    public static Stream<Integer> getDay2Input() {
        Stream<String> rawInput = getInput("AoC2019/input/day2.txt");
        return rawInput.map(Integer::valueOf);
    }

    public static Stream<String> getDay3Input() {
        return getInput("AoC2019/input/day3.txt");
    }

    public static Stream<Integer> getDay4Input() {
        Stream<String> rawInput = getInput("AoC2019/input/day4.txt");
        return rawInput.map(Integer::valueOf);
    }

    public static String getDay5Input() {
        Stream<String> rawInput = getInput("AoC2019/input/day5.txt");
        return rawInput.findFirst().get();
    }

    public static Stream<String> getDay6Input() {
        return getInput("AoC2019/input/day6.txt");
    }

    public static String getDay7Input() {
        Stream<String> rawInput = getInput("AoC2019/input/day7.txt");
        return rawInput.findFirst().get();
    }
}
