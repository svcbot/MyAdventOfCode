package AoC2019.day2;

import java.util.List;

public class Game {

    int id;
    List<RevealedCubes> revealedCubes;

    public record RevealedCubes(
            int green,
            int red,
            int blue
    ) {}
}
