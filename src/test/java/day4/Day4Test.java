package day4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Day4Test {

    @Test
    public void containsTwo() {
        int testPassword1 = 123456;
        assertFalse("Test contains double", Day4.containsTwo(testPassword1));
        assertFalse("Test contains double", Day4.containsExactlyTwo(testPassword1));

        int testPassword2 = 112233;
        assertTrue("Test contains double", Day4.containsTwo(testPassword2));
        assertTrue("Test contains double", Day4.containsExactlyTwo(testPassword2));

        int testPassword3 = 123334;
        assertTrue("Test contains double", Day4.containsTwo(testPassword3));
        assertFalse("Test contains double", Day4.containsExactlyTwo(testPassword3));
    }

    @Test
    public void noDecrease() {
        int testPassword1 = 123456;
        assertTrue("Test no decrease", Day4.noDecrease(testPassword1));

        int testPassword2 = 654321;
        assertFalse("Test no decrease", Day4.noDecrease(testPassword2));

        int testPassword3 = 123321;
        assertFalse("Test no decrease", Day4.noDecrease(testPassword3));
    }
}