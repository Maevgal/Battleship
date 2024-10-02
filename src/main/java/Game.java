public class Game {
    private Player player1;
    private Player player2;
    private final ConsoleUserInterface consoleUserInterface;

    public Game() {
        this.consoleUserInterface = new ConsoleUserInterface();
    }

    public void start() {
        //создание игроков
        player1 = new Player(consoleUserInterface);
        player1.inizialize(1);
        player2 = new Player(consoleUserInterface);
        player2.inizialize(2);
    }

    public void playGame() throws GameExeption {
        consoleUserInterface.showMessage("Игроки расставили свои корабли, приступим к игре.");

        while (true) {
            boolean isLose = player1.playerHit(player2);
            if (isLose) {
                consoleUserInterface.showMessage("Игра окончена, победил %s".formatted(player1.getPlayerName()));
                return;
            }
            isLose = player2.playerHit(player1);
            if (isLose) {
                consoleUserInterface.showMessage("Игра окончена, победил %s".formatted(player2.getPlayerName()));
                return;
            }
        }
    }
}
