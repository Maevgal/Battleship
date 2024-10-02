import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Field {
    private List<Ship> ships = new ArrayList<>();

    static final int FILED_LENGTH = 10;

    private char[][] field = new char[FILED_LENGTH][FILED_LENGTH];

    //первоночальное поле
    public Field() {
        for (int i = 0; i < FILED_LENGTH; i++) {
            for (int j = 0; j < FILED_LENGTH; j++) {
                field[j][i] = ' ';
            }
        }
    }

    public void show() {
        System.out.println("    0   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < FILED_LENGTH; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < FILED_LENGTH; j++) {
                System.out.print(field[j][i] + "\t");
            }
            System.out.println();
        }
    }

    public void addShip(String startShipPosition, String oriental, int sizeShip) throws GameExeption {
        Ship ship = new Ship(startShipPosition, oriental, sizeShip);
        Set<Coordinate> shipPosition = ship.getShipPosition();

        for (Coordinate coord : shipPosition) {
            if (coord.getX() < 0 || coord.getX() > 9 || coord.getY() < 0 || coord.getY() > 9) {
                throw new GameExeption("Корабль выходит за границы поля");
            }
        }

        Set<Coordinate> restrictionArea = new HashSet<>(shipPosition);
        for (Coordinate coord : shipPosition) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    restrictionArea.add(new Coordinate(coord.getX() + i, coord.getY() + j));
                }
            }
        }

        for (Ship s : ships) {
            Set<Coordinate> shipPosition1 = s.getShipPosition();
            for (Coordinate sh : shipPosition1) {
                if (restrictionArea.contains(sh)) {
                    throw new GameExeption("Корабль неверно расположен на поле");
                }
            }
        }
        ships.add(ship);
    }

    public char[][] getFieldWithShips() {
        char[][] fieldWitShips = new char[FILED_LENGTH][FILED_LENGTH];
        for (int i = 0; i < FILED_LENGTH; i++) {
            System.arraycopy(field[i], 0, fieldWitShips[i], 0, FILED_LENGTH);
        }

        for (Ship ship : ships) {
            Set<Coordinate> shipCoord = ship.getShipPosition();
            for (Coordinate coord : shipCoord) {
                fieldWitShips[coord.getX()][coord.getY()] = '@';
            }
        }
        return fieldWitShips;
    }

    public void drawFieldWithShips() {
        char[][] fieldWithShips = getFieldWithShips();
        System.out.println("    0   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < FILED_LENGTH; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < FILED_LENGTH; j++) {
                System.out.print(fieldWithShips[j][i] + "\t");
            }
            System.out.println();
        }
    }

    public boolean tryToHit(Coordinate coordinate) throws GameExeption {
        //в эту точку еще не стреляли?
        if (field[coordinate.getX()][coordinate.getY()] == ' ') {
            //попало ли в корабль
            //нанести отметку на точку: попал или мимо
            for (Ship ship : ships) {
                if (ship.checkHit(coordinate)) {
                    field[coordinate.getX()][coordinate.getY()] = 'X';
                    show();
                    return true;
                }
            }
        } else {
            throw new GameExeption("В данную точку выполняли удар, попробуй снова");
        }
        field[coordinate.getX()][coordinate.getY()] = 'O';
        show();
        return false;
    }

    public boolean isLose() {
        for (Ship ship : ships) {
            if (!ship.isDead()) {
                return false;
            }
        }
        return true;
    }
}
