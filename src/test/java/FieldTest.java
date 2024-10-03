import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FieldTest {
    static final String VERTICAL_ORIENTAL = "1";
    static final int HORIZONTAL_ORIENTAL = 2;

    @Test
    void addShip() throws GameExeption, NoSuchFieldException, IllegalAccessException {
        List<Ship> ships = new ArrayList<>();

        Coordinate startShipPosition = new Coordinate(1, 1);
        Orientation oriental = Orientation.VERTICAL;
        int sizeShip = 4;

        Ship ship = new Ship(startShipPosition, oriental, sizeShip);
        ships.add(ship);

        Field field = new Field();
        field.addShip(startShipPosition, oriental, sizeShip);

        java.lang.reflect.Field declaredField = field.getClass().getDeclaredField("ships");
        declaredField.setAccessible(true);

        Assertions.assertThat(declaredField.get(field)).isEqualTo(ships);
    }

    @Test
    void addShipOutsideField() {
        List<Ship> ships = new ArrayList<>();

        Coordinate startShipPosition = new Coordinate(9, 1);
        Orientation oriental = Orientation.HORIZONTAL;
        int sizeShip = 4;

        Ship ship = new Ship(startShipPosition, oriental, sizeShip);
        ships.add(ship);

        Field field = new Field();

        GameExeption exception = assertThrows(GameExeption.class, () -> {

            field.addShip(startShipPosition, oriental, sizeShip);
        });

        String expected = "Корабль выходит за границы поля";
        assertTrue(exception.getMessage().contains(expected));
    }

    @Test
    void getFieldWithShips() {
    }

    @Test
    void drawFieldWithShips() {
    }

    @Test
    void tryToHit() {
    }

    @Test
    void isLose() {
    }
}