import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class TestGame {
    static final int VERTICAL_ORIENTAL = 1;
    static final int HORIZONTAL_ORIENTAL = 2;
    static final int FILED_LENGTH = 10;

    @Test
    void startGame() throws GameExeption {
        String player1Name = "Alex";
        String player2Name = "Jane";

        String Player1Coordinate4Deck = "1 1";
        String Player1Oriental4Deck = String.valueOf(VERTICAL_ORIENTAL);

        String Player1Coordinate3DeckFirst = "3 1";
        String Player1Oriental3DeckFirst = String.valueOf(HORIZONTAL_ORIENTAL);
        String Player1Coordinate3DeckSecond = "0 6";
        String Player1Oriental3DeckSecond = String.valueOf(VERTICAL_ORIENTAL);

        String Player1Coordinate2DeckFirst = "3 3";
        String Player1Oriental2DeckFirst = String.valueOf(HORIZONTAL_ORIENTAL);
        String Player1Coordinate2DeckSecond = "7 1";
        String Player1Oriental2DeckSecond = String.valueOf(HORIZONTAL_ORIENTAL);
        String Player1Coordinate2DeckThird = "3 6";
        String Player1Oriental2DeckThird = String.valueOf(HORIZONTAL_ORIENTAL);

        String Player1Coordinate1DeckFirst = "7 5";

        String Player1Coordinate1DeckSecond = "3 8";
        String Player1Coordinate1DeckThird = "5 8";
        String Player1Coordinate1DeckFour = "9 5";

        String Player2Coordinate4Deck = "0 1";
        String Player2Oriental4Deck = String.valueOf(HORIZONTAL_ORIENTAL);

        String Player2Coordinate3DeckFirst = "5 1";
        String Player2Oriental3DeckFirst = String.valueOf(HORIZONTAL_ORIENTAL);
        String Player2Coordinate3DeckSecond = "9 0";
        String Player2Oriental3DeckSecond = String.valueOf(VERTICAL_ORIENTAL);

        String Player2Coordinate2DeckFirst = "0 3";
        String Player2Oriental2DeckFirst = String.valueOf(HORIZONTAL_ORIENTAL);
        String Player2Coordinate2DeckSecond = "0 7";
        String Player2Oriental2DeckSecond = String.valueOf(HORIZONTAL_ORIENTAL);
        String Player2Coordinate2DeckThird = "0 5";
        String Player2Oriental2DeckThird = String.valueOf(HORIZONTAL_ORIENTAL);

        String Player2Coordinate1DeckFirst = "0 9";

        String Player2Coordinate1DeckSecond = "4 8";
        String Player2Coordinate1DeckThird = "7 7";
        String Player2Coordinate1DeckFour = "4 4";

        int size1Deck = 1;
        int size2Deck = 2;
        int size3Deck = 3;
        int size4Deck = 4;

        Field player1Field = new Field();
        player1Field.addShip(Player1Coordinate4Deck, Player1Oriental4Deck, size4Deck);
        player1Field.addShip(Player1Coordinate3DeckFirst, Player1Oriental3DeckFirst, size3Deck);
        player1Field.addShip(Player1Coordinate3DeckSecond, Player1Oriental3DeckSecond, size3Deck);
        player1Field.addShip(Player1Coordinate2DeckFirst, Player1Oriental2DeckFirst, size2Deck);
        player1Field.addShip(Player1Coordinate2DeckSecond, Player1Oriental2DeckSecond, size2Deck);
        player1Field.addShip(Player1Coordinate2DeckThird, Player1Oriental2DeckThird, size2Deck);
        player1Field.addShip(Player1Coordinate1DeckFirst, Player1Oriental4Deck, size1Deck);
        player1Field.addShip(Player1Coordinate1DeckSecond, Player1Oriental4Deck, size1Deck);
        player1Field.addShip(Player1Coordinate1DeckThird, Player1Oriental4Deck, size1Deck);
        player1Field.addShip(Player1Coordinate1DeckFour, Player1Oriental4Deck, size1Deck);

        Field player2Field = new Field();
        player2Field.addShip(Player2Coordinate4Deck, Player2Oriental4Deck, size4Deck);
        player2Field.addShip(Player2Coordinate3DeckFirst, Player2Oriental3DeckFirst, size3Deck);
        player2Field.addShip(Player2Coordinate3DeckSecond, Player2Oriental3DeckSecond, size3Deck);
        player2Field.addShip(Player2Coordinate2DeckFirst, Player2Oriental2DeckFirst, size2Deck);
        player2Field.addShip(Player2Coordinate2DeckSecond, Player2Oriental2DeckSecond, size2Deck);
        player2Field.addShip(Player2Coordinate2DeckThird, Player2Oriental2DeckThird, size2Deck);
        player2Field.addShip(Player2Coordinate1DeckFirst, Player2Oriental4Deck, size1Deck);
        player2Field.addShip(Player2Coordinate1DeckSecond, Player2Oriental4Deck, size1Deck);
        player2Field.addShip(Player2Coordinate1DeckThird, Player2Oriental4Deck, size1Deck);
        player2Field.addShip(Player2Coordinate1DeckFour, Player2Oriental4Deck, size1Deck);

        Player player1 = new Player(player1Name, player1Field);
        Player player2 = new Player(player2Name, player2Field);

        Set<Coordinate> shipPositionPlayer1 = new HashSet<>();
        shipPositionPlayer1.add(new Coordinate(1, 1));
        shipPositionPlayer1.add(new Coordinate(1, 2));
        shipPositionPlayer1.add(new Coordinate(1, 3));
        shipPositionPlayer1.add(new Coordinate(1, 4));

        shipPositionPlayer1.add(new Coordinate(0, 6));
        shipPositionPlayer1.add(new Coordinate(0, 7));
        shipPositionPlayer1.add(new Coordinate(0, 8));

        shipPositionPlayer1.add(new Coordinate(3, 1));
        shipPositionPlayer1.add(new Coordinate(4, 1));
        shipPositionPlayer1.add(new Coordinate(5, 1));

        shipPositionPlayer1.add(new Coordinate(7, 1));
        shipPositionPlayer1.add(new Coordinate(8, 1));

        shipPositionPlayer1.add(new Coordinate(3, 3));
        shipPositionPlayer1.add(new Coordinate(4, 3));

        shipPositionPlayer1.add(new Coordinate(3, 6));
        shipPositionPlayer1.add(new Coordinate(4, 6));

        shipPositionPlayer1.add(new Coordinate(3, 8));
        shipPositionPlayer1.add(new Coordinate(5, 8));
        shipPositionPlayer1.add(new Coordinate(7, 5));
        shipPositionPlayer1.add(new Coordinate(9, 5));

        Set<Coordinate> shipPositionPlayer2 = new HashSet<>();
        shipPositionPlayer2.add(new Coordinate(0, 1));
        shipPositionPlayer2.add(new Coordinate(1, 1));
        shipPositionPlayer2.add(new Coordinate(2, 1));
        shipPositionPlayer2.add(new Coordinate(3, 1));

        shipPositionPlayer2.add(new Coordinate(5, 1));
        shipPositionPlayer2.add(new Coordinate(6, 1));
        shipPositionPlayer2.add(new Coordinate(7, 1));

        shipPositionPlayer2.add(new Coordinate(9, 1));
        shipPositionPlayer2.add(new Coordinate(9, 2));
        shipPositionPlayer2.add(new Coordinate(9, 3));

        shipPositionPlayer2.add(new Coordinate(0, 3));
        shipPositionPlayer2.add(new Coordinate(1, 3));

        shipPositionPlayer2.add(new Coordinate(0, 5));
        shipPositionPlayer2.add(new Coordinate(1, 5));

        shipPositionPlayer2.add(new Coordinate(0, 7));
        shipPositionPlayer2.add(new Coordinate(1, 7));

        shipPositionPlayer2.add(new Coordinate(0, 9));
        shipPositionPlayer2.add(new Coordinate(4, 4));
        shipPositionPlayer2.add(new Coordinate(4, 8));
        shipPositionPlayer2.add(new Coordinate(7, 7));
    }
}
