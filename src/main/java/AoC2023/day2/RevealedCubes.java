package AoC2023.day2;

import java.util.Objects;

public final class RevealedCubes {
    public int red;
    public int green;
    public int blue;

    public RevealedCubes() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    public RevealedCubes(
            int red,
            int green,
            int blue
    ) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (RevealedCubes) obj;
        return this.red == that.red &&
                this.green == that.green &&
                this.blue == that.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }

    @Override
    public String toString() {
        return "RevealedCubes[" +
                "red=" + red + ", " +
                "green=" + green + ", " +
                "blue=" + blue + ']';
    }

}
