package day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    static String puzzleInput = "132709\n" +
            "102150\n" +
            "126463\n" +
            "85035\n" +
            "77219\n" +
            "86458\n" +
            "119251\n" +
            "121098\n" +
            "118730\n" +
            "122505\n" +
            "127964\n" +
            "68004\n" +
            "55833\n" +
            "77664\n" +
            "142865\n" +
            "124503\n" +
            "115892\n" +
            "87236\n" +
            "122743\n" +
            "127096\n" +
            "94893\n" +
            "62129\n" +
            "56520\n" +
            "117000\n" +
            "81519\n" +
            "121719\n" +
            "96291\n" +
            "96556\n" +
            "79006\n" +
            "137122\n" +
            "124340\n" +
            "125151\n" +
            "51603\n" +
            "50132\n" +
            "67568\n" +
            "132599\n" +
            "149009\n" +
            "60997\n" +
            "99382\n" +
            "96506\n" +
            "57269\n" +
            "118133\n" +
            "115119\n" +
            "126208\n" +
            "101098\n" +
            "60514\n" +
            "146171\n" +
            "70314\n" +
            "76473\n" +
            "51209\n" +
            "99190\n" +
            "57647\n" +
            "126985\n" +
            "142055\n" +
            "99615\n" +
            "146442\n" +
            "129520\n" +
            "145334\n" +
            "57799\n" +
            "87148\n" +
            "118362\n" +
            "80407\n" +
            "106449\n" +
            "57146\n" +
            "129035\n" +
            "60156\n" +
            "120016\n" +
            "147383\n" +
            "68819\n" +
            "83868\n" +
            "81021\n" +
            "131594\n" +
            "137692\n" +
            "86537\n" +
            "110709\n" +
            "127678\n" +
            "106849\n" +
            "137640\n" +
            "108482\n" +
            "131412\n" +
            "70331\n" +
            "90118\n" +
            "117557\n" +
            "117347\n" +
            "84688\n" +
            "108869\n" +
            "145359\n" +
            "127024\n" +
            "100976\n" +
            "90419\n" +
            "53362\n" +
            "106100\n" +
            "129474\n" +
            "56101\n" +
            "99975\n" +
            "79211\n" +
            "99865\n" +
            "121099\n" +
            "74511\n" +
            "123172";

    public static List<Integer> getComponentMassList() {
        return Arrays.stream(puzzleInput.split("\\n"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

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
        List<Integer> initialMass = getComponentMassList();
        int totalFuel = 0;
        for (int componentMass : initialMass) {
            totalFuel += computeFuelForMass(componentMass);
        }
        System.out.printf("Day 1 stage 1 result %d", totalFuel );
        return totalFuel;
    }

    public static int solveStage2() {
        List<Integer> initialMass = getComponentMassList();
        int totalFuel = 0;
        for (int componentMass : initialMass) {
            totalFuel += computeFuelTotalMass(componentMass);
        }
        System.out.printf("Day 1 stage 2 result %d", totalFuel );
        return totalFuel;
    }
}
