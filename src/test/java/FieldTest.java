import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FieldTest {
    static final String VERTICAL_ORIENTAL = "1";
    static final int HORIZONTAL_ORIENTAL = 2;

    @Test
    void addShip() throws GameExeption, NoSuchFieldException, IllegalAccessException {
        List<Ship> ships = new ArrayList<>();

        String startShipPosition = "1 1";
        String oriental = VERTICAL_ORIENTAL;
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