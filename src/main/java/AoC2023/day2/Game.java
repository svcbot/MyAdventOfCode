package AoC2023.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    static final Pattern gameRecordPattern = Pattern.compile("^Game (\\d+): (.*)$");
    static final Pattern diePattern = Pattern.compile("(\\d+) (red|blue|green)");

    public int id;
    List<RevealedCubes> cubeSets = new ArrayList<>();

    public Game(String gameLine) {
        Matcher matcher = gameRecordPattern.matcher(gameLine);
        matcher.find();
        id = Integer.parseInt(matcher.group(1));
        String subsetsLine = matcher.group(2);
        String[] subsets = subsetsLine.split(";");
        for (String subset : subsets) {
            String[] reveledDice = subset.split(", ");
            RevealedCubes revealedCubes = new RevealedCubes(0, 0, 0);
            cubeSets.add(revealedCubes);
            for (String die : reveledDice) {
                Matcher dieMatcher = diePattern.matcher(die);
                dieMatcher.find();
                int dieAmount = Integer.parseInt(dieMatcher.group(1));
                String color = dieMatcher.group(2);
                switch (color) {
                    case "red" -> revealedCubes.red = dieAmount;
                    case "green" -> revealedCubes.green = dieAmount;
                    case "blue" -> revealedCubes.blue = dieAmount;
                }
            }
        }
    }

    public boolean isPossible(RevealedCubes invariant) {
        for (RevealedCubes subset : cubeSets) {
            if (subset.red > invariant.red || subset.green > invariant.green || subset.blue > invariant.blue) {
                return false;
            }
        }
        return true;
    }

    public int getPower() {
        RevealedCubes minCubeSet = new RevealedCubes();
        for (RevealedCubes subset : cubeSets) {
            if (subset.red > minCubeSet.red) minCubeSet.red = subset.red;
            if (subset.green > minCubeSet.green) minCubeSet.green = subset.green;
            if (subset.blue > minCubeSet.blue) minCubeSet.blue = subset.blue;
        }
        return minCubeSet.red * minCubeSet.green * minCubeSet.blue;
    }

}
