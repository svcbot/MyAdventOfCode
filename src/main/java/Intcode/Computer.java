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
    boolean DEBUG = false;

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

    /**
     * Loads new intcode into the memory. All flags and inputs are reset.
     *
     * @param intcode Program to execute on the computer
     */
    public void loadMemory(String intcode) {
        this.memory = Arrays.stream(intcode.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        instructionPointer = 0;
        reset();
    }

    private void reset() {
        ERROR = false;
        DONE = false;
        input.clear();
        output.clear();
    }

    public void loadMemory(List<Integer> intcode) {
        this.memory = intcode;
    }

    public void loadInput(List<Integer> input) {
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
            case 7:
            case 8:
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
            case 5:
            case 6:
                return new Instruction(
                        opcode,
                        paramModes,
                        memory.get(instructionPointer + 1),
                        memory.get(instructionPointer + 2)
                );
            case 99:
                return new Instruction(
                        opcode,
                        paramModes,
                        1
                );
            default:
                LOG.warning("Unknown instruction code decoded: " + opcode);
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

            if (DEBUG) {
                LOG.info("IP: " + instructionPointer
                        + "\nExecuting: : " + instruction
                        + "\nMemory dump: " + memory
                        + "\nRegisters dump: " + Arrays.toString(registers)
                        + "\nInput: " + input
                        + "\nOutput: " + output
                        + "\n-----------------------------");
            }

            execute(instruction);
            if (instructionPointer >= memory.size()) ERROR = true;
        }
        if (ERROR) LOG.warning("Error occurred during run!");
//        if(DONE && !ERROR) LOG.info("Run successful!\n--------------------");
    }

    private void execute(Instruction instruction) {

        switch (instruction.opcode) {
            case 1:
                ADD(instruction.params.get(0), instruction.params.get(1), instruction.params.get(2));
                break;
            case 2:
                MULT(instruction.params.get(0), instruction.params.get(1), instruction.params.get(2));
                break;
            case 3:
                IN(2, instruction.params.get(0));
                break;
            case 4:
                OUT(2, instruction.params.get(0));
                break;
            case 5:
            case 6:
                ERROR = true; // not implemented yet
                break;
            case 7:
                LT(instruction.params.get(0), instruction.params.get(1), instruction.params.get(2));
                break;
            case 8:
                EQ(instruction.params.get(0), instruction.params.get(1), instruction.params.get(2));
                break;
            case 99:
                DONE = true;
                break;
            default:
                LOG.warning("Could not execute an unknown instruction: " + instruction.opcode);
                ERROR = true;
        }

        instructionPointer += instruction.offset;
    }

    private void LT(Param param1, Param param2, Param param3) {
        MOV(0, param1);
        MOV(1, param2);
        registers[2] = registers[0] < registers[1] ? 1 : 0;
        LOAD(2, param3);
    }

    private void EQ(Param param1, Param param2, Param param3) {
        MOV(0, param1);
        MOV(1, param2);
        registers[2] = registers[0] == registers[1] ? 1 : 0;
        LOAD(2, param3);
    }

    private void OUT(int regIndex, Param param) {
        MOV(regIndex, param);
        output.add(registers[regIndex]);
    }

    private void IN(int regIndex, Param param) {
        MOV(regIndex, param);
        registers[regIndex] = input.remove(0);
        LOAD(regIndex, param);
    }

    private void MULT(Param param1, Param param2, Param param3) {
        MOV(0, param1);
        MOV(1, param2);
        registers[2] = registers[0] * registers[1];
        LOAD(2, param3);
    }

    private void ADD(Param param1, Param param2, Param param3) {
        MOV(0, param1);
        MOV(1, param2);
        registers[2] = registers[0] + registers[1];
        LOAD(2, param3);
    }

    /**
     * Read from memory and write into register regIndex
     *
     * @param regIndex index of the regIndex
     * @param param    instruction parameter,
     *                 which contains parameter value and parameter mode
     */
    private void MOV(int regIndex, Param param) {
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
     * Read from register regIndex and write into memory
     *
     * @param regIndex index of the regIndex
     * @param param    instruction parameter,
     *                 which contains parameter value and parameter mode
     */
    private void LOAD(int regIndex, Param param) {
        // will never be in immediate mode
        memory.set(param.value, registers[regIndex]);
    }

    public String printMemory() {
        return memory.stream().map(Object::toString).collect(Collectors.joining(","));
    }
}
