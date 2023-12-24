package AoC2023.day3;

public class SomeNumber {
    public int line;
    public int startIndex;
    public int endIndex;
    public int value;

    public SomeNumber() {
    }

    public SomeNumber(int line, int startIndex, int endIndex, int value) {
        this.line = line;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SomeNumber{" +
                "line=" + line +
                ", startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                ", value=" + value +
                '}';
    }
}
