package AoC2019.day2;

import AoC2019.Intcode.Computer;
import Util.PuzzleInput;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Day2 {
    static Logger LOG = Logger.getLogger(Day2.class.toString());

    public static int solveStage1() {
        List<Integer> inputList = PuzzleInput.getDay2Input();
        inputList.set(1, 12);
        inputList.set(2, 2);

        Computer computer = new Computer(inputList);
        computer.run();
        return computer.memory.get(0);
    }

    public static int solveStage2() {
        PuzzleInput.getDay2Input();
        List<Integer> initialProgramm = PuzzleInput.getDay2Input();
        List<Integer> input;

        int result = 0;
        Computer computer = new Computer();

        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                input = new ArrayList<>(initialProgramm);
                input.set(1, noun);
                input.set(2, verb);

                computer.loadMemory(initialProgramm);
                computer.run();
                result = computer.memory.get(0);
                if (result == 19690720) {
                    int puzzleResult = noun * 100 + verb;
                    LOG.info("Solution for day 2 stage 2 is " + puzzleResult);
                    return puzzleResult;
                }
            }
        }

        return -1;
    }
}
