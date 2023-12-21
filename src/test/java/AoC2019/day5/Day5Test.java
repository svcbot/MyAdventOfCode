package AoC2019.day5;

import AoC2019.Intcode.Computer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5Test {

    @Test
    void testEQInstruction() {

        Computer computer = new Computer();
        List<Integer> input = new ArrayList<>();

        // Test EQ instruction in position mode

        String eqPositionModeTestProgram = "3,9,8,9,10,9,4,9,99,-1,8";

        computer.loadMemory(eqPositionModeTestProgram);
        input.add(8);
        computer.loadInput(input);
        computer.run();
        assertEquals(1, (int) computer.output.get(0), "Test EQ PM 8");

        computer.loadMemory(eqPositionModeTestProgram);
        input.clear();
        input.add(1);
        computer.loadInput(input);
        computer.run();
        assertEquals(0, (int) computer.output.get(0), "Test NEQ PM 8");

        // Test EQ instruction in immediate mode
        String eqImmediateModeTestProgram = "3,3,1108,-1,8,3,4,3,99";

        computer.loadMemory(eqImmediateModeTestProgram);
        input.clear();
        input.add(8);
        computer.loadInput(input);
        computer.run();
        assertEquals(1, (int) computer.output.get(0), "Test EQ IM 8");

        computer.loadMemory(eqImmediateModeTestProgram);
        input.clear();
        input.add(1);
        computer.loadInput(input);
        computer.run();
        assertEquals(0, (int) computer.output.get(0), "Test NEQ IM 8");
    }

    @Test
    void testLTInstruction() {

        Computer computer = new Computer();
        List<Integer> input = new ArrayList<>();

        // Test LT instruction in position mode

        String ltPositionModeTestProgram = "3,9,7,9,10,9,4,9,99,-1,8";
        computer.loadMemory(ltPositionModeTestProgram);
        input.add(7);
        computer.loadInput(input);
        computer.run();
        assertEquals(1, (int) computer.output.get(0), "Test LT PM < 8");

        computer.loadMemory(ltPositionModeTestProgram);
        input.clear();
        input.add(10);
        computer.loadInput(input);
        computer.run();
        assertEquals(0, (int) computer.output.get(0), "Test LT PM >= 8");

        // Test LT instruction in immediate mode

        String ltImmediateModeTestProgram = "3,3,1107,-1,8,3,4,3,99";

        computer.loadMemory(ltImmediateModeTestProgram);
        input.clear();
        input.add(1);
        computer.loadInput(input);
        computer.run();
        assertEquals(1, (int) computer.output.get(0), "Test LT IM < 8");

        computer.loadMemory(ltImmediateModeTestProgram);
        input.clear();
        input.add(11);
        computer.loadInput(input);
        computer.run();
        assertEquals(0, (int) computer.output.get(0), "Test LT IM >= 8");
    }

    @Test
    void testJumpInstructions() {

        Computer computer = new Computer();
        List<Integer> input = new ArrayList<>();

        // Test jump instructions in position mode

        String jumpPositionModeTestProgram = "3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9";
        computer.loadMemory(jumpPositionModeTestProgram);
        input.add(0);
        computer.loadInput(input);
        computer.run();
        assertEquals(0, (int) computer.output.get(0), "Test jumps negative");

        computer.loadMemory(jumpPositionModeTestProgram);
        input.add(10);
        computer.loadInput(input);
        computer.run();
        assertEquals(1, (int) computer.output.get(0), "Test jumps positive");

        // Test jump instructions in immediate mode

        String jumpImmediateModeTestProgram = "3,3,1105,-1,9,1101,0,0,12,4,12,99,1";
        computer.loadMemory(jumpImmediateModeTestProgram);
        input.add(0);
        computer.loadInput(input);
        computer.run();
        assertEquals(0, (int) computer.output.get(0), "Test jumps negative");

        computer.loadMemory(jumpImmediateModeTestProgram);
        input.add(10);
        computer.loadInput(input);
        computer.run();
        assertEquals(1, (int) computer.output.get(0), "Test jumps positive");
    }

    @Test
    void testComplexExample() {
        String complexTestProgram = "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
                "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
                "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99";

        Computer computer = new Computer();
        List<Integer> input = new ArrayList<>();

        computer.loadMemory(complexTestProgram);
        input.add(7);
        computer.loadInput(input);
        computer.run();
        assertEquals(999, (int) computer.output.get(0), "Complex test < 8");

        computer.loadMemory(complexTestProgram);
        input.add(8);
        computer.loadInput(input);
        computer.run();
        assertEquals(1000, (int) computer.output.get(0), "Complex test == 8");

        computer.loadMemory(complexTestProgram);
        input.add(9);
        computer.loadInput(input);
        computer.run();
        assertEquals(1001, (int) computer.output.get(0), "Complex test == 8");
    }
}
