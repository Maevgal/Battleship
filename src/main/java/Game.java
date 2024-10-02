import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    static final int VERTICAL_ORIENTAL = 1;
    static final int HORIZONTAL_ORIENTAL = 2;

    public void start() {
        //создать игроков
        System.out.println("Игрок 1 введи свое имя");
        player1 = createPlayer();
        player1.createShips();
        System.out.println("Игрок 2 введи свое имя");
        player2 = createPlayer();
        player2.createShips();
    }

    private Player createPlayer() {
        Scanner scanner = new Scanner(System.in);
        return new Player(scanner.nextLine());
    }

    public void playGame() throws GameExeption {
        System.out.println(("Игроки расставили свои корабли, приступим к игре. Игрок %s введи через пробел " +
                "координаты для удара")
                .formatted(player1.getPlayerName()));
        boolean isLose = false;
        while (!isLose) {
            isLose = playerHit(player2);
            if (isLose) {
                System.out.println("Игра окончена, победил %s".formatted(player1.getPlayerName()));
                return;
            }
            isLose = playerHit(player1);
            if (isLose) {
                System.out.println("Игра окончена, победил %s".formatted(player2.getPlayerName()));
                return;
            }
        }
    }

    private boolean playerHit(Player player) {
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
}
