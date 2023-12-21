package AoC2019.day3;

import java.util.Objects;
import java.util.Optional;

public class WireSection {
    public Point start;
    public Point end;
    public int lowerX;
    public int upperX;
    public int lowerY;
    public int upperY;
    public Orientation orientation;
    public int length;

    public WireSection(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.lowerX = Math.min(start.x, end.x);
        this.upperX = Math.max(start.x, end.x);
        this.lowerY = Math.min(start.y, end.y);
        this.upperY = Math.max(start.y, end.y);
        if (start.x == end.x) {
            orientation = Orientation.vertical;
        } else if (start.y == end.y) {
            orientation = Orientation.horizontal;
        }
        length = start.distanceTo(end);
    }

    public WireSection(int startX, int startY, int endX, int endY) {
        this(new Point(startX, startY), new Point(endX, endY));
    }

    public WireSection(Point start, String directionCode) {
        this(start, getEndFromDirectionCode(start, directionCode));
    }

    private static Point getEndFromDirectionCode(Point start, String directionCode) {
        String direction = directionCode.substring(0, 1);
        int length = Integer.parseInt(directionCode.substring(1));
        return start.add(direction, length);
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
                if (lowerY <= wireSection.start.y && wireSection.start.y <= upperY
                        && wireSection.lowerX <= start.x && start.x <= wireSection.upperX
                ) {
                    return Optional.of(new Point(start.x, wireSection.start.y));
                }
            } else {
                if (lowerX <= wireSection.start.x && wireSection.start.x <= upperX
                        && wireSection.lowerY <= start.y && start.y <= wireSection.upperY
                ) {
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

    public boolean contains(Point i) {
        return lowerX <= i.x && i.x <= upperX && lowerY <= i.y && i.y <= upperY;
    }
}
