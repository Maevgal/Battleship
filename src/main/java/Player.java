import java.util.Scanner;

public class Player {
    private final String playerName;
    private final Field field;
    static String VERTICAL_ORIENTAL = "1";

    public Player(String playerName) {
        this.playerName = playerName;
        this.field = new Field();
    }

    public Player(String playerName, Field field) {
        this.playerName = playerName;
        this.field = field;
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
                System.out.println("%s введи через пробел координаты начала расположения %s-х палубного корабля и нажми enter"
                        .formatted(playerName, sizeShip));
                String startShipPosition = scanner.nextLine();
                String oriental;
                if (sizeShip > 1) {
                    System.out.println("Выбери как ты хочешь расположить корабль и нажми enter:" + "\n" +
                            "1 - по вертикали" + "\n" +
                            "2 - по горизонтали");
                    oriental = scanner.nextLine();
                } else {
                    oriental = VERTICAL_ORIENTAL;
                }
                try {
                    field.addShip(startShipPosition, oriental, sizeShip);
                    field.drawFieldWithShips();
                } catch (GameExeption e) {
                    System.out.println(e.getMessage());
                    j--;
                }
            }
            count++;
            sizeShip--;
        }
    }

    public boolean playerHit(Player player) {
        player.showFieldWitoutShip();
        Scanner scanner = new Scanner(System.in);
        boolean hit = true;
        while (hit) {
            String answer = scanner.nextLine();
            String[] coordinate = answer.split(" ");
            int x = Integer.parseInt(coordinate[0]);
            int y = Integer.parseInt(coordinate[1]);
            try {
                hit = player.tryToHit(x, y);
            } catch (GameExeption e) {
                System.out.println(e.getMessage());
            }
            if (hit) {
                //проверка на конец игры
                if (player.isLose()) {
                    return true;
                } else {
                    System.out.println("Попал. Стреляй еще раз");
                }
            } else {
                System.out.println("Мимо. Передай игру игроку %s".formatted(player.getPlayerName()));
            }
        }
        return false;
    }

    public void showFieldWitoutShip() {
        field.show();
    }

    public boolean tryToHit(int x, int y) throws GameExeption {
        Coordinate coordinate = new Coordinate(x, y);
        return field.tryToHit(coordinate);
    }

    public boolean isLose() {
        return field.isLose();
    }
}
