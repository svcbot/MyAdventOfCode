package AoC2023.day3;

public class Symbol {
    int line;
    int offset;
    String value;

    public Symbol() {
    }

    public Symbol(int line, int offset, String value) {
        this.line = line;
        this.offset = offset;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "line=" + line +
                ", offset=" + offset +
                ", value=" + value +
                '}';
    }
}
