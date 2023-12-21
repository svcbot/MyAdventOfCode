package AoC2023;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {

    // inefficient, but I'm impatient
    private static final Pattern firstDigit = Pattern.compile("(?=(one|two|three|four|five|six|seven|eight|nine|\\d)).*$");
    private static final Pattern lastDigit = Pattern.compile("^.*(?=(one|two|three|four|five|six|seven|eight|nine|\\d))");

    public static Optional<Integer> calculateCalibrationValue(List<String> inputLines) {
        return inputLines.stream()
                .map(line -> line.replaceAll("[^0-9.]", ""))
                .map(line -> line.charAt(0) + line.substring(line.length() - 1))
                .map(Integer::valueOf)
                .reduce(Integer::sum);
    }

    public static Optional<Integer> calculateCalibrationValuePart2(List<String> inputLines) {
        return inputLines.stream()
                .map(Day1::extractTwoDigitNumberAlphanumeric)
                .map(Integer::valueOf)
                .reduce(Integer::sum);
    }

    public static String extractTwoDigitNumberAlphanumeric(String input) {
        Matcher fdm = firstDigit.matcher(input);
        Matcher ldm = lastDigit.matcher(input);
        fdm.find();
        ldm.find();
        return replaceWordByNumber(fdm.group(1)) + replaceWordByNumber(ldm.group(1));
    }

    private static String replaceWordByNumber(String input) {
        return input
                .replaceAll("one", "1")
                .replaceAll("two", "2")
                .replaceAll("three", "3")
                .replaceAll("four", "4")
                .replaceAll("five", "5")
                .replaceAll("six", "6")
                .replaceAll("seven", "7")
                .replaceAll("eight", "8")
                .replaceAll("nine", "9")
                ;
    }
}
