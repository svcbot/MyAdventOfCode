package day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay2 {

    @Test
    public void testStage1() {
        assertEquals("Test 1 + 1 = 2: ", "2,0,0,0,99", Day2.processIntcode("1,0,0,0,99"));
        assertEquals("Test 3 * 2 = 6: ", "2,3,0,6,99", Day2.processIntcode("2,3,0,3,99"));
        assertEquals("Test 99 * 99 = 9801: ", "2,4,4,5,99,9801", Day2.processIntcode("2,4,4,5,99,0"));
        assertEquals("Test complex example: ", "30,1,1,4,2,5,6,0,99", Day2.processIntcode("1,1,1,4,99,5,6,0,99"));
    }
}
