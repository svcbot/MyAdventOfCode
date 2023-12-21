package AoC2019.day7;

import Util.Converter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThrustersArrayTest {

    @Test
    void thrustersArrayTestExpectedSignal() {
        String testProgram1 = "3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0";
        List<Integer> phaseConfig1 = Converter.stringToIntList("4,3,2,1,0");
        final int expectedSignal1 = 43210;
        ThrustersArray thrustersArray = new ThrustersArray(testProgram1, phaseConfig1);
        int actualSignal = thrustersArray.evaluate();

        assertEquals(expectedSignal1, actualSignal, "Expected signal 1");

        String testProgram2 = "3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0";
        List<Integer> phaseConfig2 = Converter.stringToIntList("0,1,2,3,4");
        final int expectedSignal2 = 54321;
        thrustersArray = new ThrustersArray(testProgram2, phaseConfig2);
        int actualSignal2 = thrustersArray.evaluate();

        assertEquals(expectedSignal2, actualSignal2, "Expected signal 2");

        String testProgram3 = "3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0";
        List<Integer> phaseConfig3 = Converter.stringToIntList("1,0,4,3,2");
        final int expectedSignal3 = 65210;
        thrustersArray = new ThrustersArray(testProgram3, phaseConfig3);
        int actualSignal3 = thrustersArray.evaluate();

        assertEquals(expectedSignal3, actualSignal3, "Expected signal 3");
    }

    @Test
    void amplifiedThrustersArrayTest() {
        String testProgram1 = "3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5";
        List<Integer> phaseConfig1 = Converter.stringToIntList("9,8,7,6,5");
        final int expectedSignal1 = 139629729;

        AmplifiedThrustersArray amplifiedThrustersArray = new AmplifiedThrustersArray(testProgram1, phaseConfig1);
        int actualSignal = amplifiedThrustersArray.evaluate();
        assertEquals(expectedSignal1, actualSignal, "Expected signal 1");
    }
}
