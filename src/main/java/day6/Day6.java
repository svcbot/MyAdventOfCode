package day6;

import Util.PuzzleInput;

import java.util.List;
import java.util.logging.Logger;

public class Day6 {

    static Logger LOG = Logger.getLogger(Day6.class.toString());

    public static int solveStage1() {
        List<String> puzzleInput = PuzzleInput.getDay6Input();
        return solveStage1(puzzleInput);
    }

    public static int solveStage1(List<String> puzzleInput) {
        UniversalOrbitMap orbitMap = new UniversalOrbitMap(puzzleInput);
        int orbitCountChecksum = orbitMap.getOrbitCountChecksum();

        LOG.info("Solution for day 6 stage 1 is " + orbitCountChecksum);

        return orbitCountChecksum;
    }

    public static int solveStage2() {
        List<String> puzzleInput = PuzzleInput.getDay6Input();
        return solveStage2(puzzleInput);
    }

    public static int solveStage2(List<String> puzzleInput) {
        UniversalOrbitMap orbitMap = new UniversalOrbitMap(puzzleInput);
        int transfers = orbitMap.getTransfersCount("YOU", "SAN");

        LOG.info("Solution for day 6 stage 2 is " + transfers);

        return transfers;
    }
}
