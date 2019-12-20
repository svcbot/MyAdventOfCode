package day7;

import Intcode.Computer;

import java.util.List;

public class ThrustersArray {
    String amplifierControllerProgram;
    List<Integer> phaseSettings;
    private Computer[] thrustersArrayComputers = new Computer[5];

    public ThrustersArray(String amplifierControllerProgram, List<Integer> phaseSettings) {
        this.amplifierControllerProgram = amplifierControllerProgram;
        this.phaseSettings = phaseSettings;
    }

    public int evaluate() {
        int lastOutput = 0;

        for (int i = 0; i < thrustersArrayComputers.length; i++) {
            thrustersArrayComputers[i] = new Computer(amplifierControllerProgram);
            thrustersArrayComputers[i].input.add(phaseSettings.get(i));
            thrustersArrayComputers[i].input.add(lastOutput);
            thrustersArrayComputers[i].run();
            lastOutput = thrustersArrayComputers[i].output.get(0);
        }

        return lastOutput;
    }
}
