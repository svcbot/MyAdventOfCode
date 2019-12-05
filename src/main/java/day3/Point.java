package day3;

import java.util.Objects;

public class Point {
    public int x;
    public int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point add(String direction, int length) {
        switch (direction) {
            case "R":
                return new Point(x + length, y);
            case "L":
                return new Point(x - length, y);
            case "U":
                return new Point(x, y + length);
            case "D":
                return new Point(x, y - length);
            default: return null;
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
