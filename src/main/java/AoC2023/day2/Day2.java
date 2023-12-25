package AoC2023.day2;

import java.util.Optional;
import java.util.stream.Stream;

public class Day2 {

    public static Optional<Integer> solvePart1(Stream<String> input) {
        RevealedCubes invariant = new RevealedCubes(12, 13, 14);
        return input
                .map(Game::new)
                .filter(game -> game.isPossible(invariant))
                .map(game -> game.id)
                .reduce(Integer::sum);
    }

    public static Optional<Integer> solvePart2(Stream<String> input) {
        return input
                .map(Game::new)
                .map(Game::getPower)
                .reduce(Integer::sum);
    }
}
