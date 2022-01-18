package day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day4Test {

    @Test
    void containsTwo() {
        int testPassword1 = 123456;
        assertFalse(Day4.containsTwo(testPassword1), "Test contains double 1");
        assertFalse(Day4.containsExactlyTwo(testPassword1), "Test contains double 1");

        int testPassword2 = 112233;
        assertTrue(Day4.containsTwo(testPassword2), "Test contains double 2");
        assertTrue(Day4.containsExactlyTwo(testPassword2), "Test contains double 2");

        int testPassword3 = 123334;
        assertTrue(Day4.containsTwo(testPassword3), "Test contains double 3");
        assertFalse(Day4.containsExactlyTwo(testPassword3), "Test contains double 3");
    }

    @Test
    void noDecrease() {
        int testPassword1 = 123456;
        assertTrue(Day4.noDecrease(testPassword1), "Test no decrease 1");

        int testPassword2 = 654321;
        assertFalse(Day4.noDecrease(testPassword2), "Test no decrease 2");

        int testPassword3 = 123321;
        assertFalse(Day4.noDecrease(testPassword3), "Test no decrease 3");
    }
}