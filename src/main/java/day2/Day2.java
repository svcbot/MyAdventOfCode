package day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {
    static String puzzleInput = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,6,19,1,9,19,23,1,6,23,27,1,10,27,31,1,5,31,35,2,6,35,39,1,5,39,43,1,5,43,47,2,47,6,51,1,51,5,55,1,13,55,59,2,9,59,63,1,5,63,67,2,67,9,71,1,5,71,75,2,10,75,79,1,6,79,83,1,13,83,87,1,10,87,91,1,91,5,95,2,95,10,99,2,9,99,103,1,103,6,107,1,107,10,111,2,111,10,115,1,115,6,119,2,119,9,123,1,123,6,127,2,127,10,131,1,131,6,135,2,6,135,139,1,139,5,143,1,9,143,147,1,13,147,151,1,2,151,155,1,10,155,0,99,2,14,0,0";

    public static List<Integer> getInputList() {
        return Arrays.stream(puzzleInput.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static List<Integer> getInputList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static String solveStage1() {
        List<Integer> inputList = getInputList();
        inputList.set(1,12);
        inputList.set(2,2);

        return processIntcode(inputList);
    }

    public static int solveStage2() {
        List<Integer> inputList = getInputList();
        int result = 0;
        boolean ready = false;

        for (int noun = 0; noun < 100 ; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                inputList = getInputList();
                inputList.set(1,noun);
                inputList.set(2,verb);

                processIntcode(inputList);
                result = inputList.get(0);
                if (result == 19690720) {
                    int puzzleResult = noun*100 + verb;
                    System.out.println(puzzleResult);
                    return puzzleResult;
                }
            }
        }

        return -1;
    }

    public static String processIntcode(String intcode) {
        List<Integer> intcodeList = getInputList(intcode);
        return processIntcode(intcodeList);
    }

    public static String processIntcode(List<Integer> intcode) {
        int instructionPointer = 0;
        int arg1 = 0;
        int arg1Value = 0;
        int arg2 = 0;
        int arg2Value = 0;
        int resultPosition = 0;
        int resultValue = 0;
        boolean errorOccurred = false;
        boolean finished = false;

        while (instructionPointer < intcode.size() && !errorOccurred && !finished) {
            int opcode = intcode.get(instructionPointer);

            switch (opcode) {
                case 1:
                    arg1 = intcode.get(instructionPointer + 1);
                    arg1Value = intcode.get(arg1);
                    arg2 = intcode.get(instructionPointer + 2);
                    arg2Value = intcode.get(arg2);
                    resultPosition = intcode.get(instructionPointer + 3);
                    resultValue = arg1Value + arg2Value;
                    intcode.set(resultPosition, resultValue);
                    //System.out.printf("add [%d]->%d, [%d]->%d, [%d]->%d\n", arg1, arg1Value, arg2, arg2Value, resultPosition, resultValue);
                    break;
                case 2:
                    arg1 = intcode.get(instructionPointer + 1);
                    arg1Value = intcode.get(arg1);
                    arg2 = intcode.get(instructionPointer + 2);
                    arg2Value = intcode.get(arg2);
                    resultPosition = intcode.get(instructionPointer + 3);
                    resultValue = arg1Value * arg2Value;
                    intcode.set(resultPosition, resultValue);
                    //System.out.printf("mult [%d]->%d, [%d]->%d, [%d]->%d\n", arg1, arg1Value, arg2, arg2Value, resultPosition, resultValue);
                    break;
                case 99:
                    finished = true;
                    //System.out.println("finish");
                    break;
                default:
                    System.out.println("Error occurred");
                    errorOccurred = true;
                    break;
            }

            instructionPointer += 4;
        }

        return intcode.stream().map(Object::toString).collect(Collectors.joining(","));
    }
}
