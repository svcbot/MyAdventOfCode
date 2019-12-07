package day4;

import day3.Day3;

import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day4 {

    static Logger LOG = Logger.getLogger(Day3.class.toString());
    static int puzzleInput1 = 271973;
    static int puzzleInput2 = 785961;

    public static int solveStage1() {
        return solveStage1(puzzleInput1, puzzleInput2);
    }

    public static int solveStage1(int puzzleInput1, int puzzleInput2) {
        int passwordsAmount = countPasswords(puzzleInput1, puzzleInput2);

        LOG.info("Day 4 Stage 1 solution is " + passwordsAmount);
        return passwordsAmount;
    }

    public static int solveStage2() {
        return solveStage2(puzzleInput1, puzzleInput2);
    }

    public static int solveStage2(int puzzleInput1, int puzzleInput2) {
        int passwordsAmount = countPasswordsStage2(puzzleInput1, puzzleInput2);

        LOG.info("Day 4 Stage 1 solution is " + passwordsAmount);
        return passwordsAmount;
    }

    private static int countPasswords(int lowerBound, int upperBound) {
        return (int) IntStream.rangeClosed(lowerBound, upperBound)
                .filter(n -> noDecrease(n) && containsTwo(n)) // Efficiency? We don't do that here
                .count();
    }

    private static int countPasswordsStage2(int lowerBound, int upperBound) {
        return (int) IntStream.rangeClosed(lowerBound, upperBound)
                .filter(n -> noDecrease(n) && containsExactlyTwo(n)) // Efficiency? We don't do that here either
                .count();
    }

    public static boolean containsTwo(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] == digits[i + 1]) return true;
        }
        return false;
    }

    public static boolean containsExactlyTwo(int n) {
        return String.valueOf(n).chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .containsValue(2L);
    }

    public static boolean noDecrease(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] > digits[i + 1]) return false;
        }
        return true;
    }
}
