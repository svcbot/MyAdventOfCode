package day7;

import Util.Permutations;
import Util.PuzzleInput;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day7 {
    static Logger LOG = Logger.getLogger(Day7.class.toString());

    public static int solveStage1() {
        String puzzleInput = PuzzleInput.getDay7Input();
        return solveStage1(puzzleInput);
    }

    private static int solveStage1(String puzzleInput) {
        int largestSignal = 0;

        List<Integer> phaseSettings = Arrays.asList(0, 1, 2, 3, 4);
        Stream<Stream<Integer>> phaseSettingsPermutations = Permutations.of(phaseSettings);

        largestSignal = phaseSettingsPermutations.map(settings -> {
            ThrustersArray thrustersArray = new ThrustersArray(puzzleInput, settings.collect(Collectors.toList()));
            return thrustersArray.evaluate();
        }).sorted().max(Integer::compareTo).orElseThrow(NoSuchElementException::new);

        LOG.info("Largest thrusters signal is: " + largestSignal);

        return largestSignal;
    }


    public static int solveStage2() {
        String puzzleInput = PuzzleInput.getDay7Input();
        return solveStage2(puzzleInput);
    }

    private static int solveStage2(String puzzleInput) {
        return 0;
    }
}
