package AoC2023.day1;

import AoC2023.Day1;
import Util.PuzzleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day1Test {

    @Test
    void should_calculate_day1_part1_example() {
        final String exampleInput = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet""";

        Optional<Integer> calibrationValue = Day1.calculateCalibrationValue(exampleInput.lines().collect(Collectors.toList()));
        Assertions.assertTrue(calibrationValue.isPresent());
        Assertions.assertEquals(142, calibrationValue.get());
    }

    @Test
    void should_calculate_day1_part2_example() {
        final String exampleInput = """
                two1nine
                eightwothree
                abcone2threexyz
                xtwone3four
                4nineeightseven2
                zoneight234
                7pqrstsixteen""";

        Optional<Integer> calibrationValue = Day1.calculateCalibrationValuePart2(exampleInput.lines().collect(Collectors.toList()));
        Assertions.assertTrue(calibrationValue.isPresent());
        Assertions.assertEquals(281, calibrationValue.get());
    }

    @Test
    void should_extractNumbers() {
        String numbers1 = Day1.extractTwoDigitNumberAlphanumeric("two1nine");
        Assertions.assertEquals("29", numbers1);

        String numbers2 = Day1.extractTwoDigitNumberAlphanumeric("oneightwo");
        Assertions.assertEquals("12", numbers2);

        String numbers3 = Day1.extractTwoDigitNumberAlphanumeric("twonenine");
        Assertions.assertEquals("29", numbers3);

        String numbers4 = Day1.extractTwoDigitNumberAlphanumeric("threeightwo");
        Assertions.assertEquals("32", numbers4);

        String numbers5 = Day1.extractTwoDigitNumberAlphanumeric("fiveighthree");
        Assertions.assertEquals("53", numbers5);

        String numbers6 = Day1.extractTwoDigitNumberAlphanumeric("sevenineight");
        Assertions.assertEquals("78", numbers6);

        String numbers7 = Day1.extractTwoDigitNumberAlphanumeric("eighthreeightwo");
        Assertions.assertEquals("82", numbers7);

        String numbers8 = Day1.extractTwoDigitNumberAlphanumeric("nineightwone");
        Assertions.assertEquals("91", numbers8);
    }

    @Test
    void solvePart1() {
        List<String> input = PuzzleInput.getInput("AoC2023/day1.txt");
        Assertions.assertEquals(1000, input.size());
        Optional<Integer> calibrationValue = Day1.calculateCalibrationValue(input);
        Assertions.assertTrue(calibrationValue.isPresent());
        System.out.printf("Day 1 part 1 result is %s%n", calibrationValue.get());
    }

    @Test
    void solvePart2() {
        List<String> input = PuzzleInput.getInput("AoC2023/day1.txt");
        Optional<Integer> calibrationValue = Day1.calculateCalibrationValuePart2(input);
        Assertions.assertTrue(calibrationValue.isPresent());
        System.out.printf("Day 1 part 2 result is %s%n", calibrationValue.get());
    }
}
