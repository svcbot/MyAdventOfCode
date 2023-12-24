package AoC2023.day2;

import java.util.List;
import java.util.Optional;

public class Day2 {

    public static Optional<Integer> solvePart1(List<String> input) {
        RevealedCubes invariant = new RevealedCubes(12, 13, 14);
        return input.stream()
                .map(Game::new)
                .filter(game -> game.isPossible(invariant))
                .map(game -> game.id)
                .reduce(Integer::sum);
    }

    public static Optional<Integer> solvePart2(List<String> input) {
        return input.stream()
                .map(Game::new)
                .map(Game::getPower)
                .reduce(Integer::sum);
    }
}
