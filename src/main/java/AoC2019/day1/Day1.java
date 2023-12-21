package AoC2019.day1;

import java.util.List;

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
        List<Integer> initialMass = getDay1Input();
        int totalFuel = 0;
        for (int componentMass : initialMass) {
            totalFuel += computeFuelForMass(componentMass);
        }
        System.out.printf("Day 1 stage 1 result %d", totalFuel );
        return totalFuel;
    }

    public static int solveStage2() {
        List<Integer> initialMass = getDay1Input();
        int totalFuel = 0;
        for (int componentMass : initialMass) {
            totalFuel += computeFuelTotalMass(componentMass);
        }
        System.out.printf("Day 1 stage 2 result %d", totalFuel );
        return totalFuel;
    }
}
