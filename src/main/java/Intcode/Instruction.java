package Intcode;

import java.util.ArrayList;
import java.util.List;

public class Instruction {
    int opcode;
    int length;
    List<Param> params = new ArrayList<>();

    public Instruction(int opcode, int paramModes, int... args) {
        this.opcode = opcode;

        switch (opcode) {
            case 1:
            case 2:
                params.add(new Param(args[0], paramModes % 10));
                params.add(new Param(args[1], (paramModes / 10) % 10));
                params.add(new Param(args[2], (paramModes / 100) % 10));
                length = 4;
                break;
            case 3:
            case 4:
                params.add(new Param(args[0], paramModes % 10));
                length = 2;
                break;
            case 99:
                length = 1;
                break;
        }
    }
}
