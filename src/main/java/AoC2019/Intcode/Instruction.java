package AoC2019.Intcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a decoded instruction
 *
 * @param opcode represents instructions opcode
 * @param offset indicates how much the instruction pointer has to be offset,
 *               after the instructions is executed
 */
public class Instruction {
    int opcode;
    int offset;
    List<Param> params = new ArrayList<>();

    public Instruction(int opcode, int paramModes, int... args) {
        this.opcode = opcode;

        switch (opcode) {
            case 1:
            case 2:
            case 7:
            case 8:
                params.add(new Param(args[0], paramModes % 10));
                params.add(new Param(args[1], (paramModes / 10) % 10));
                params.add(new Param(args[2], (paramModes / 100) % 10));
                offset = 4;
                break;
            case 3:
            case 4:
                params.add(new Param(args[0], paramModes % 10));
                offset = 2;
                break;
            case 5:
            case 6:
                params.add(new Param(args[0], paramModes % 10));
                params.add(new Param(args[1], (paramModes / 10) % 10));
                offset = 0;
                break;
            case 99:
                offset = 0;
                break;
            default:
                Computer.LOG.warning("Unknown instruction created: " + opcode);
                break;
        }
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "opcode=" + opcode +
                ", offset=" + offset +
                ", params=" + params +
                '}';
    }
}
