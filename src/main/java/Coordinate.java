public class Coordinate {
    private final int x;
    private final int y;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate that)) return false;

        return getX() == that.getX() && getY() == that.getY();
    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
