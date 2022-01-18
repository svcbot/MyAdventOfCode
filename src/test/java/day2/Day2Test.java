package day2;

import Intcode.Computer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {

    @Test
    void testStage1() {
        Computer computer = new Computer();

        computer.loadMemory("1,0,0,0,99");
        computer.run();
        assertEquals("2,0,0,0,99", computer.printMemory(), "Test 1 + 1 = 2: ");

        computer.loadMemory("2,3,0,3,99");
        computer.run();
        assertEquals("2,3,0,6,99", computer.printMemory(), "Test 3 * 2 = 6: ");

        computer.loadMemory("2,4,4,5,99,0");
        computer.run();
        assertEquals("2,4,4,5,99,9801", computer.printMemory(), "Test 99 * 99 = 9801: ");

        computer.loadMemory("1,1,1,4,99,5,6,0,99");
        computer.run();
        assertEquals( "30,1,1,4,2,5,6,0,99", computer.printMemory(), "Test complex example: ");
    }

    @Test
    void testStage2() {
        // this test will only work with my input
        assertEquals(5379, Day2.solveStage2(), "Test day 2 stage 2 ");
    }
}
