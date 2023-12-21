package AoC2019.day7;

import AoC2019.Intcode.Computer;

import java.util.LinkedList;
import java.util.List;

public class AmplifiedThrustersArray {

    private final String amplifierControllerProgram;
    private final List<Integer> phaseSettings;
    private final LinkedList<Computer> thrustersArrayComputers = new LinkedList<>();
    private int arraysOutput;

    public AmplifiedThrustersArray(String amplifierControllerProgram, List<Integer> phaseSettings) {
        this.amplifierControllerProgram = amplifierControllerProgram;
        this.phaseSettings = phaseSettings;

        initializeThrustersArray();
    }

    public int evaluate() {
        boolean loop = true;
        int index = 0;
        thrustersArrayComputers.get(0).input.add(arraysOutput);

        while (loop) {
            int nextIndex = (index + 1) % 5;
            Computer computer = thrustersArrayComputers.get(index);
            computer.run();
            if (computer.output.isEmpty()) {
                loop = false;
            } else {
                final int lastOutput = computer.output.get(computer.output.size() - 1);
                if (index == 4) arraysOutput = lastOutput;
                thrustersArrayComputers.get(nextIndex).input.add(lastOutput);
                index = nextIndex;
            }
        }

        return arraysOutput;
    }

    private void initializeThrustersArray() {
        Computer computerA = new Computer(amplifierControllerProgram);
        Computer computerB = new Computer(amplifierControllerProgram);
        Computer computerC = new Computer(amplifierControllerProgram);
        Computer computerD = new Computer(amplifierControllerProgram);
        Computer computerE = new Computer(amplifierControllerProgram);

        thrustersArrayComputers.addAll(List.of(computerA, computerB, computerC, computerD, computerE));

        // initialize phases
        for (int i = 0; i < thrustersArrayComputers.size(); i++) {
            thrustersArrayComputers.get(i).input.add(phaseSettings.get(i));
        }

        // initial state of computer A
        computerA.input.add(0);
    }
}
