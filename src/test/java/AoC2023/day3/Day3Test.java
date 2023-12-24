package AoC2023.day3;

import Util.PuzzleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class Day3Test {

    @Test
    void should_solve_part1_example1() {
        String exampleInput = """
                467..114..
                ...*......
                ..35..633.
                ......#...
                617*......
                .....+.58.
                ..592.....
                ......755.
                ...$.*....
                .664.598..""";

        Day3 day3 = new Day3();
        Optional<Integer> partsSum = day3.solvePart1(exampleInput.lines().toList());

        Assertions.assertTrue(partsSum.isPresent());
        Assertions.assertEquals(4361, partsSum.get());
    }

    @Test
    void should_solve_part1_example2() {
        String exampleInput = """
                1000.100
                ..2.#.3.
                ...1.10.
                """;

        Day3 day3 = new Day3();
        Optional<Integer> partsSum = day3.solvePart1(exampleInput.lines().toList());

        Assertions.assertTrue(partsSum.isPresent());
        Assertions.assertEquals(1111, partsSum.get());
    }

    @Test
    void should_solve_part1_example3() {
        String exampleInput = """
                3..2000.4
                ...2#20..
                6..200.5.
                """;

        Day3 day3 = new Day3();
        Optional<Integer> partsSum = day3.solvePart1(exampleInput.lines().toList());

        Assertions.assertTrue(partsSum.isPresent());
        Assertions.assertEquals(2222, partsSum.get());
    }

    @Test
    void should_solve_part2_example() {
        String exampleInput = """
                467..114..
                ...*......
                ..35..633.
                ......#...
                617*......
                .....+.58.
                ..592.....
                ......755.
                ...$.*....
                .664.598..""";

        Day3 day3 = new Day3();
        Optional<Integer> partsSum = day3.solvePart2(exampleInput.lines().toList());

        Assertions.assertTrue(partsSum.isPresent());
        Assertions.assertEquals(467835, partsSum.get());
    }

    @Test
    void solvePart1() {
        List<String> input = PuzzleInput.getInput("AoC2023/day3.txt");
        Assertions.assertEquals(140, input.size());

        Day3 day3 = new Day3();
        Optional<Integer> partsSum = day3.solvePart1(input);

        Assertions.assertTrue(partsSum.isPresent());
        System.out.println("Day 3 part 1 solution is " + partsSum.get());
    }

    @Test
    void solvePart2() {
        List<String> input = PuzzleInput.getInput("AoC2023/day3.txt");

        Day3 day3 = new Day3();
        Optional<Integer> partsSum = day3.solvePart2(input);

        Assertions.assertTrue(partsSum.isPresent());
        System.out.println("Day 3 part 2 solution is " + partsSum.get());
    }
}
