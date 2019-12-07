package day4;

import day3.Day3;

import java.util.logging.Logger;
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

    private static int countPasswords(int lowerBound, int upperBound) {
        return (int) IntStream.rangeClosed(lowerBound, upperBound)
                .filter(n -> noDecrease(n) && containsPair(n)) // Efficiency? We don't do that here
                .count();
    }

    public static boolean containsPair(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] == digits[i + 1]) return true;
        }
        return false;
    }

    public static boolean noDecrease(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] > digits[i + 1]) return false;
        }
        return true;
    }
}
