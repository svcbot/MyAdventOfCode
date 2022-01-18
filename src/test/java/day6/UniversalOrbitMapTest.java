package day6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversalOrbitMapTest {

    private static final String stageOneExample = """
            COM)B
            B)C
            C)D
            D)E
            E)F
            B)G
            G)H
            D)I
            E)J
            J)K
            K)L""";

    private static final String stageTwoExample = """
            COM)B
            B)C
            C)D
            D)E
            E)F
            B)G
            G)H
            D)I
            E)J
            J)K
            K)L
            K)YOU
            I)SAN""";

    @Test
    void testStage1() {
        List<String> input = Arrays.asList(stageOneExample.split("\n"));
        UniversalOrbitMap exampleMap = new UniversalOrbitMap(input);

        assertEquals(42, exampleMap.getOrbitCountChecksum(), "Total orbits in example 1 map");
    }

    @Test
    void testStage2() {
        List<String> input = Arrays.asList(stageTwoExample.split("\n"));
        UniversalOrbitMap exampleMap = new UniversalOrbitMap(input);

        assertEquals(4, exampleMap.getTransfersCount("YOU", "SAN"), "Total orbit transfers required from YOU to SAN");
    }
}