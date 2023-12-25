package AoC2023.day3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day3 {

    final Pattern numberPattern = Pattern.compile("(\\d+)");
    final Pattern symbolPattern = Pattern.compile("([^\\w.])");

    final HashMap<Integer, List<SomeNumber>> partsByLine = new HashMap<>();
    final List<Symbol> symbols = new ArrayList<>();

    final HashMap<Symbol, List<SomeNumber>> gearsBySymbol = new HashMap<>();


    public Optional<Integer> solvePart1(Stream<String> input) {
        parseInput(input);

        return filterPartNumbers().stream()
                .map(someNumber -> someNumber.value)
                .reduce(Integer::sum);
    }

    public Optional<Integer> solvePart2(Stream<String> input) {
        parseInput(input);

        findGears();

        return gearsBySymbol.values().stream()
                .map(gears -> gears.stream()
                        .map(someNumber -> someNumber.value)
                        .reduce((a,b) -> a * b))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .reduce(Integer::sum);
    }

    private void findGears() {
        for (Symbol symbol : symbols) {
            List<SomeNumber> adjacentNumbers = findAdjacentNumbers(symbol);
            if (adjacentNumbers.size() == 2) {
                gearsBySymbol.put(symbol, adjacentNumbers);
            }
        }
    }

    public Set<SomeNumber> filterPartNumbers() {
        Set<SomeNumber> partNumbers = new HashSet<>();

        for (Symbol symbol : symbols) {
            List<SomeNumber> adjacentNumbers = findAdjacentNumbers(symbol);
            partNumbers.addAll(adjacentNumbers);
//            System.out.printf("Numbers adjacent to symbol %s:\n %s\n", symbol, adjacentNumbers);
        }

        return partNumbers;
    }

    private List<SomeNumber> findAdjacentNumbers(Symbol symbol) {
        List<SomeNumber> result = new ArrayList<>();
        int minLineIndex = Math.max(0, symbol.line - 1);
        int maxLineIndex = symbol.line + 1;

        for (int i = minLineIndex; i < maxLineIndex + 1; i++) {
            if (partsByLine.containsKey(i)) {
                result.addAll(partsByLine.get(i).stream()
                        .filter(someNumber -> isAdjacent(symbol, someNumber)).toList());
            }
        }
        return result;
    }

    private static boolean isAdjacent(Symbol symbol, SomeNumber someNumber) {
        boolean isAdjacent = (Math.max(0, someNumber.startIndex - 1) <= symbol.offset
                && symbol.offset < someNumber.endIndex + 1);
//        System.out.printf("Is number %s adjacent to a symbol %s -> %b\n", someNumber, symbol, isAdjacent);
        return isAdjacent;
    }

    public void parseNumbers(int lineNumber, String line) {
        Matcher numberMatcher = numberPattern.matcher(line);
        while (numberMatcher.find()) {
            SomeNumber someNumber = new SomeNumber(lineNumber, numberMatcher.start(), numberMatcher.end(), Integer.parseInt(numberMatcher.group()));
            List<SomeNumber> listOfPartsForLine = partsByLine.computeIfAbsent(lineNumber, integer -> new ArrayList<>());
            listOfPartsForLine.add(someNumber);
        }
    }

    public void parseSymbols(int lineNumber, String line) {
        Matcher symbolMatcher = symbolPattern.matcher(line);
        while (symbolMatcher.find()) {
            Symbol symbol = new Symbol(lineNumber, symbolMatcher.start(), symbolMatcher.group());
            symbols.add(symbol);
        }
    }

    public void parseInput(Stream<String> input) {
        List<String> lines = input.toList();
        for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
            String line = lines.get(lineNumber);
            parseNumbers(lineNumber, line);
            parseSymbols(lineNumber, line);
        }
    }
}
