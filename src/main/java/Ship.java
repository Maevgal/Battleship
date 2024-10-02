import java.util.HashSet;
import java.util.Set;

public class Ship {
    private final Set<Coordinate> shipPosition = new HashSet<>();
    private int countHit = 0;
    static String VERTICAL_ORIENTAL = "1";

    public Ship(String startShipPosition, String oriental, int sizeShip) {
        String[] startShipPositionArr = startShipPosition.split(" ");
        int x = Integer.parseInt(startShipPositionArr[0]);
        int y = Integer.parseInt(startShipPositionArr[1]);
        if (oriental.equals(VERTICAL_ORIENTAL)) {
            for (int k = 0; k < sizeShip; k++) {
                shipPosition.add(new Coordinate(x, y + k));
            }
        } else {
            for (int k = 0; k < sizeShip; k++) {
                shipPosition.add(new Coordinate(x + k, y));
            }
        }
    }

    public Set<Coordinate> getShipPosition() {
        return shipPosition;
    }

    //проверка на попадание в корабль
    public boolean checkHit(Coordinate hit) {
        if (shipPosition.contains(hit)) {
            countHit++;
        }
        return shipPosition.contains(hit);
    }

    //проверка на то что корабль убит
    public boolean isDead() {
        return shipPosition.size() == countHit;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ship ship)) return false;

        return countHit == ship.countHit && getShipPosition().equals(ship.getShipPosition());
    }

    @Override
    public int hashCode() {
        int result = getShipPosition().hashCode();
        result = 31 * result + countHit;
        return result;
    }
}
