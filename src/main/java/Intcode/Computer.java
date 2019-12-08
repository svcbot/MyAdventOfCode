package Intcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Computer {

    static Logger LOG = Logger.getLogger(Computer.class.toString());

    public List<Integer> memory = new ArrayList<>();
    public List<Integer> input = new ArrayList<>();
    public List<Integer> output = new ArrayList<>();
    public int[] registers = new int[3];
    public int instructionPointer = 0;
    // flags
    boolean ERROR = false;
    boolean DONE = false;

    public Computer() {

    }

    public Computer(List<Integer> memory) {
        this.memory = memory;
    }

    public Computer(String intcode) {
        loadMemory(intcode);
    }

    public Computer(String intcode, List<Integer> input) {
        loadMemory(intcode);
        this.input = input;
    }

    public void loadMemory(String intcode) {
        this.memory = Arrays.stream(intcode.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        instructionPointer = 0;
        resetFlags();
    }

    private void resetFlags() {
        ERROR = false;
        DONE = false;
    }

    public void loadMemory(List<Integer> intcode) {
        this.memory = intcode;
    }

    public void loadInput(ArrayList<Integer> input) {
        this.input = input;
    }

    private int fetch() {
        return memory.get(instructionPointer);
    }

    private Instruction decode(int instructionCode) {
        int opcode = instructionCode % 100;
        int paramModes = instructionCode / 100;

        switch (opcode) {
            case 1:
            case 2:
                return new Instruction(
                        opcode,
                        paramModes,
                        memory.get(instructionPointer + 1),
                        memory.get(instructionPointer + 2),
                        memory.get(instructionPointer + 3)
                );
            case 3:
            case 4:
                return new Instruction(
                        opcode,
                        paramModes,
                        memory.get(instructionPointer + 1)
                );
            case 99:
                return new Instruction(
                        opcode,
                        paramModes,
                        1
                );
            default:
                return new Instruction(
                        opcode,
                        paramModes
                );
        }
    }

    public void run() {
        int instructionCode;
        while (!ERROR && !DONE) {
            instructionCode = fetch();
            Instruction instruction = decode(instructionCode);
            execute(instruction);
            if (instructionPointer >= memory.size()) ERROR = true;
        }

//        if(DONE && !ERROR) LOG.info("Run successful!");
    }

    private void execute(Instruction instruction) {

        switch (instruction.opcode) {
            case 1:
                mov(0, instruction.params.get(0));
                mov(1, instruction.params.get(1));
                add(0, 1, 2, instruction.params.get(2));
                break;
            case 2:
                mov(0, instruction.params.get(0));
                mov(1, instruction.params.get(1));
                mult(0, 1, 2, instruction.params.get(2));
                break;
            case 3:
                mov(0, instruction.params.get(0));
                in(0, instruction.params.get(0));
                break;
            case 4:
                mov(0, instruction.params.get(0));
                out(0, instruction.params.get(0));
                break;
            case 99:
                DONE = true;
                break;
            default:
                LOG.warning("Unknown opcode:" + instruction.opcode);
                ERROR = true;
        }

        instructionPointer += instruction.length;
    }

    private void out(int regIndex, Param param) {
        mov(regIndex, param);
        output.add(registers[regIndex]);
    }

    private void in(int regIndex, Param param) {
        registers[regIndex] = input.remove(0);
        load(regIndex, param);
    }

    private void mult(int param1, int param2, int regIndex, Param param) {
        registers[regIndex] = registers[param1] * registers[param2];
        load(regIndex, param);
    }

    private void add(int param1, int param2, int regIndex, Param param) {
        registers[regIndex] = registers[param1] + registers[param2];
        load(regIndex, param);
    }

    /**
     * Read from memory and write into regIndex
     *
     * @param regIndex index of the regIndex
     * @param param    instruction parameter,
     *                 which contains parameter value and parameter mode
     */
    private void mov(int regIndex, Param param) {
        if (param.mode == 0) {
            registers[regIndex] = memory.get(param.value);
        } else if (param.mode == 1) {
            registers[regIndex] = param.value;
        } else {
            LOG.warning("Unknown param mode");
            ERROR = true;
        }
    }

    /**
     * Read from regIndex and write into memory
     *
     * @param regIndex index of the regIndex
     * @param param    instruction parameter,
     *                 which contains parameter value and parameter mode
     */
    private void load(int regIndex, Param param) {
        // will never be in immediate mode
        memory.set(param.value, registers[regIndex]);
    }

    public String printMemory() {
        return memory.stream().map(Object::toString).collect(Collectors.joining(","));
    }
}
