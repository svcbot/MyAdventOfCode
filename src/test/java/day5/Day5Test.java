package day5;

import Intcode.Computer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day5Test {

    @Test
    public void testEQInstruction() {

        Computer computer = new Computer();
        List<Integer> input = new ArrayList<>();

        // Test EQ instruction in position mode

        String eqPositionModeTestProgram = "3,9,8,9,10,9,4,9,99,-1,8";

        computer.loadMemory(eqPositionModeTestProgram);
        input.add(8);
        computer.loadInput(input);
        computer.run();
        assertEquals("Test EQ PM 8", 1, (int) computer.output.get(0));

        computer.loadMemory(eqPositionModeTestProgram);
        input.clear();
        input.add(1);
        computer.loadInput(input);
        computer.run();
        assertEquals("Test NEQ PM 8", 0, (int) computer.output.get(0));

        // Test EQ instruction in immediate mode
        String eqImmediateModeTestProgram = "3,3,1108,-1,8,3,4,3,99";

        computer.loadMemory(eqImmediateModeTestProgram);
        input.clear();
        input.add(8);
        computer.loadInput(input);
        computer.run();
        assertEquals("Test EQ IM 8", 1, (int) computer.output.get(0));

        computer.loadMemory(eqImmediateModeTestProgram);
        input.clear();
        input.add(1);
        computer.loadInput(input);
        computer.run();
        assertEquals("Test NEQ IM 8", 0, (int) computer.output.get(0));
    }

    @Test
    public void testLTInstruction() {

        Computer computer = new Computer();
        List<Integer> input = new ArrayList<>();

        // Test LT instruction in position mode

        String ltPositionModeTestProgram = "3,9,7,9,10,9,4,9,99,-1,8";
        computer.loadMemory(ltPositionModeTestProgram);
        input.add(7);
        computer.loadInput(input);
        computer.run();
        assertEquals("Test LT PM < 8", 1, (int) computer.output.get(0));

        computer.loadMemory(ltPositionModeTestProgram);
        input.clear();
        input.add(10);
        computer.loadInput(input);
        computer.run();
        assertEquals("Test LT PM >= 8", 0, (int) computer.output.get(0));

        // Test LT instruction in immediate mode
        String ltImmediateModeTestProgram = "3,3,1107,-1,8,3,4,3,99";

        computer.loadMemory(ltImmediateModeTestProgram);
        input.clear();
        input.add(1);
        computer.loadInput(input);
        computer.run();
        assertEquals("Test LT IM < 8", 1, (int) computer.output.get(0));

        computer.loadMemory(ltImmediateModeTestProgram);
        input.clear();
        input.add(11);
        computer.loadInput(input);
        computer.run();
        assertEquals("Test LT IM >= 8", 0, (int) computer.output.get(0));
    }
}
