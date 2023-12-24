package AoC2023.day2;

import Util.PuzzleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class Day2Test {

    @Test
    void should_solve_part1_example() {
        List<String> input = """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green""".lines().toList();

        Optional<Integer> result = Day2.solvePart1(input);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(8, result.get());
    }

    @Test
    void should_solve_part2_example() {
        List<String> input = """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green""".lines().toList();

        Optional<Integer> result = Day2.solvePart2(input);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(2286, result.get());
    }

    @Test
    void solvePart1() {
        List<String> input = PuzzleInput.getInput("AoC2023/day2.txt");
        Assertions.assertEquals(100, input.size());

        Optional<Integer> result = Day2.solvePart1(input);
        Assertions.assertTrue(result.isPresent());
        System.out.println("Day 2 part 1 solution is " + result.get());
    }

    @Test
    void solvePart2() {
        List<String> input = PuzzleInput.getInput("AoC2023/day2.txt");
        Optional<Integer> result = Day2.solvePart2(input);
        Assertions.assertTrue(result.isPresent());
        System.out.println("Day 2 part 2 solution is " + result.get());
    }
}
