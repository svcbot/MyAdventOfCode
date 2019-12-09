package day6;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UniversalOrbitMapTest {

    public String stageOneExample = "COM)B\n" +
            "B)C\n" +
            "C)D\n" +
            "D)E\n" +
            "E)F\n" +
            "B)G\n" +
            "G)H\n" +
            "D)I\n" +
            "E)J\n" +
            "J)K\n" +
            "K)L";

    public String stageTwoExample = "COM)B\n" +
            "B)C\n" +
            "C)D\n" +
            "D)E\n" +
            "E)F\n" +
            "B)G\n" +
            "G)H\n" +
            "D)I\n" +
            "E)J\n" +
            "J)K\n" +
            "K)L\n" +
            "K)YOU\n" +
            "I)SAN";

    @Test
    public void testStage1() {
        List<String> input = Arrays.asList(stageOneExample.split("\n"));
        UniversalOrbitMap exampleMap = new UniversalOrbitMap(input);

        assertEquals("Total orbits in example 1 map", 42, exampleMap.getOrbitCountChecksum());
    }

    @Test
    public void testStage2() {
        List<String> input = Arrays.asList(stageTwoExample.split("\n"));
        UniversalOrbitMap exampleMap = new UniversalOrbitMap(input);

        assertEquals("Total orbit transfers required from YOU to SAN", 4, exampleMap.getTransfersCount("YOU", "SAN"));
    }
}