package AoC2019.Intcode;

public class Param {
    int value;
    int mode;

    public Param(int value, int mode) {
        this.value = value;
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "Param{" +
                "value=" + value +
                ", mode=" + mode +
                '}';
    }
}
