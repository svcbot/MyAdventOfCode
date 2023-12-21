package AoC2019.day5;

import AoC2019.Intcode.Computer;
import Util.PuzzleInput;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Day5 {

    static Logger LOG = Logger.getLogger(Day5.class.toString());

    public static int solveStage1() {
        String puzzleInput = PuzzleInput.getDay5Input();
        return solveStage1(puzzleInput);
    }

    public static int solveStage1(String puzzleInput) {

        List<Integer> input = new ArrayList<Integer>();
        input.add(1);
        Computer computer = new Computer(puzzleInput, input);
        computer.run();

        List<Integer> output = computer.output;
        LOG.info("Full output is:\n" + output);

        if (analyzeOutput(output)) {
            Integer diagnosticsCode = output.get(output.size() - 1);
            LOG.info("Solution for day5 stage 1 is " + diagnosticsCode);
            return diagnosticsCode;
        } else {
            LOG.warning("Something is wrong!");
            return -1;
        }
    }

    public static int solveStage2() {
        String puzzleInput = PuzzleInput.getDay5Input();
        return solveStage2(puzzleInput);
    }

    public static int solveStage2(String puzzleInput) {

        List<Integer> input = new ArrayList<Integer>();
        input.add(5);
        Computer computer = new Computer(puzzleInput, input);
        computer.run();

        List<Integer> output = computer.output;
        LOG.info("Full output is:\n" + output);

        Integer diagnosticsCode = output.get(0);
        LOG.info("Solution for day5 stage 2 is " + diagnosticsCode);
        return diagnosticsCode;
    }

    /**
     * Checks whether every test returns a zero and that the diagnostics output is a non zero number
     *
     * @param output Output after running the TEST program with an input.
     * @return whether all tests were successful
     */
    private static boolean analyzeOutput(List<Integer> output) {
        if (output.isEmpty()) return false;

        for (int i = 0; i < output.size() - 1; i++) {
            Integer o = output.get(i);
            if (o != 0) return false;
        }

        return output.get(output.size() - 1) != 0;
    }

}
