package day2;

import Intcode.Computer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day2Test {

    @Test
    public void testStage1() {
        Computer computer = new Computer();

        computer.loadMemory("1,0,0,0,99");
        computer.run();
        assertEquals("Test 1 + 1 = 2: ", "2,0,0,0,99", computer.printMemory());

        computer.loadMemory("2,3,0,3,99");
        computer.run();
        assertEquals("Test 3 * 2 = 6: ", "2,3,0,6,99", computer.printMemory());

        computer.loadMemory("2,4,4,5,99,0");
        computer.run();
        assertEquals("Test 99 * 99 = 9801: ", "2,4,4,5,99,9801", computer.printMemory());

        computer.loadMemory("1,1,1,4,99,5,6,0,99");
        computer.run();
        assertEquals("Test complex example: ", "30,1,1,4,2,5,6,0,99", computer.printMemory());
    }

    public void testStage2() {
        // this test will only work with my input
        assertEquals("Test day 2 stage 2 ", 5379, Day2.solveStage2());
    }
}
