package AoC2019.day1;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static Util.PuzzleInput.getDay1Input;

public class Day1 {

    public static int computeFuelForMass(int mass) {
        return mass/3 - 2;
    }

    public static int computeFuelTotalMass(int mass) {
        int totalFuelMass = computeFuelForMass(mass);
        int fuelForFuel = computeFuelForMass(totalFuelMass);
        while (fuelForFuel > 0) {
            totalFuelMass += fuelForFuel;
            fuelForFuel = computeFuelForMass(fuelForFuel);
        }
        return totalFuelMass;
    }

    public static int solveStage1() {
        Stream<Integer> initialMass = getDay1Input();
        Optional<Integer> sum = initialMass
                .map(Day1::computeFuelForMass)
                .reduce(Integer::sum);

        if (sum.isEmpty()) {
            System.out.println("Error during calculation");
            return 0;
        } else {
            System.out.printf("Day 1 stage 1 result %d", sum.get() );
            return sum.get();
        }
    }

    public static int solveStage2() {
        Stream<Integer> initialMass = getDay1Input();
        Optional<Integer> sum = initialMass
                .map(Day1::computeFuelTotalMass)
                .reduce(Integer::sum);

        if (sum.isEmpty()) {
            System.out.println("Error during calculation");
            return 0;
        } else {
            System.out.printf("Day 1 stage 2 result %d", sum.get() );
            return sum.get();
        }
    }
}
