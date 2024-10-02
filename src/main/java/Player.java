import java.util.Scanner;

public class Player {
    private String playerName;
    private final Field field;
    private final ConsoleUserInterface consoleUserInterface;

    public Player(ConsoleUserInterface consoleUserInterface) {
        this.consoleUserInterface = consoleUserInterface;
        this.field = new Field();
    }

    public void inizialize(int numberPlayer) {
        this.playerName = consoleUserInterface.getString("Игрок %s введи свое имя".formatted(numberPlayer));
        createShips();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void createShips() {
        //создание кораболей на поле
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        int sizeShip = 4;
        for (int i = 0; count < 5; i++) {
            for (int j = 0; j < count; j++) {
                consoleUserInterface.showMessage(("%s введи через пробел координаты " +
                        "начала расположения %s-х палубного корабля и нажми enter").formatted(playerName, sizeShip));
                Coordinate startShipPosition = consoleUserInterface.getCoordinate();
                Orientation oriental;
                if (sizeShip > 1) {
                    oriental = consoleUserInterface.getOriental("Выбери как ты хочешь расположить корабль и нажми enter:" + "\n" +
                            "1 - по вертикали" + "\n" +
                            "2 - по горизонтали");
                } else {
                    oriental = Orientation.VERTICAL;
                }
                try {
                    field.addShip(startShipPosition, oriental, sizeShip);
                    char[][] fieldWithShips = field.getFieldWithShips();
                    consoleUserInterface.showField(fieldWithShips);
                } catch (GameExeption e) {
                    consoleUserInterface.showMessage(e.getMessage());
                    j--;
                }
            }
            count++;
            sizeShip--;
        }
    }

    public boolean playerHit(Player enemy) {
        enemy.showFieldWitoutShip();
        boolean hit = true;
        while (hit) {
            consoleUserInterface.showMessage("Игрок %s введи через пробел координаты для удара"
                            .formatted(this.playerName));
            Coordinate coordinate = consoleUserInterface.getCoordinate();
            try {
                hit = enemy.tryToHit(coordinate);
            } catch (GameExeption e) {
                consoleUserInterface.showMessage(e.getMessage());
            }
            if (hit) {
                //проверка на конец игры
                if (enemy.isLose()) {
                    return true;
                } else {
                    consoleUserInterface.showMessage("Попал. Стреляй еще раз");
                }
            } else {
                consoleUserInterface.showMessage("Мимо. Передай игру игроку %s".formatted(enemy.getPlayerName()));
            }
        }
        return false;
    }

    public void showFieldWitoutShip() {
        consoleUserInterface.showField(field.getField());
    }

    public boolean tryToHit(Coordinate coordinate) throws GameExeption {
        boolean result = field.tryToHit(coordinate);
        consoleUserInterface.showField(field.getField());
        return result;
    }

    public boolean isLose() {
        return field.isLose();
    }
}
