import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;

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
            isLose = player1.playerHit(player2);
            if (isLose) {
                System.out.println("Игра окончена, победил %s".formatted(player1.getPlayerName()));
                return;
            }
            isLose = player2.playerHit(player1);
            if (isLose) {
                System.out.println("Игра окончена, победил %s".formatted(player2.getPlayerName()));
                return;
            }
        }
    }


}
