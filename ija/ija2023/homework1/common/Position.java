package ija.ija2023.homework1.common;

public class Position {
    private final int x;
    private final int y;

    public Position(int row, int col) {
        x = col;
        y = row;
    }

    public static Position xy(int x, int y) {
        return new Position(y, x);
    }

    public int getCol() {
        return y;
    }

    public int getRow() {
        return x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position move(int angle) {
        int x = (int)Math.round(Math.cos(-(angle - 90) / 180. * Math.PI));
        int y = (int)Math.round(Math.sin(-(angle - 90) / 180. * Math.PI));
        return Position.xy(this.x + x, this.y - y);
    }

    @Override
    public int hashCode() {
        return x ^ ((y << 16) | ((y >> 16) & 0xFFFF));
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Position pos) {
            return x == pos.x && y == pos.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
