package day3;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class WireSection {
    public Point start;
    public Point end;
    public Orientation orientation;

    public WireSection(Point start, Point end) {
        this.start = start;
        this.end = end;
        if (start.x == end.x) {
            orientation = Orientation.vertical;
        } else if (start.y == end.y) {
            orientation = Orientation.horizontal;
        }
    }

    public WireSection(Point start, String directionCode) {
        this.start = start;
        parseDirectionCode(directionCode);
    }

    private void parseDirectionCode(String directionCode) {
        String direction = directionCode.substring(0,1);
        int length = Integer.parseInt(directionCode.substring(1));
        parseOrientation(direction);
        this.end = start.add(direction, length);
    }

    public void parseOrientation(String directionChar) {
        if (directionChar.equals("L") || directionChar.equals("R")) {
            this.orientation = Orientation.horizontal;
        } else if (directionChar.equals("U") || directionChar.equals("D")) {
            this.orientation = Orientation.vertical;
        }
    }

    public Optional<Point> intersect(WireSection wireSection) {
        if (wireSection.orientation != orientation) {
            if (orientation == Orientation.vertical) {
                int smallerY = Math.min(start.y, end.y);
                int biggerY = Math.max(start.y, end.y);
                if (smallerY <= wireSection.start.y && wireSection.start.y <= biggerY) {
                    return Optional.of(new Point(start.x, wireSection.start.y));
                }
            } else {
                int smallerX = Math.min(start.x, end.x);
                int biggerX = Math.max(start.x, end.x);
                if (smallerX <= wireSection.start.x && wireSection.start.x <= biggerX) {
                    return Optional.of(new Point(wireSection.start.x, end.y));
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        return "WireSection{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WireSection that = (WireSection) o;
        return start.equals(that.start) &&
                end.equals(that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
