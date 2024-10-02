import java.util.Scanner;

public class ConsoleUserInterface {
    private final Scanner scanner = new Scanner(System.in);

    public String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public Coordinate getCoordinate() {
        while (true) {
            String str = scanner.nextLine();
            String[] coordinates = str.split(" ");
            try {
                Coordinate coordinate = new Coordinate(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
                return coordinate;
            } catch (Exception e) {
                System.out.println("Вы ввели недопустимое значение, попробуйте снова");
            }
        }
    }

    public Orientation getOriental(String message) {
        System.out.println(message);
        String str = scanner.nextLine();
        while (true) {
            if (str.equals("1")) {
                return Orientation.VERTICAL;
            } else if (str.equals("2")) {
                return Orientation.HORIZONTAL;
            } else {
                System.out.println("Вы ввели недопустимое значение, попробуйте снова");
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showField(char[][] fieldWithShips) {
        System.out.println("    0   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < fieldWithShips.length; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < fieldWithShips.length; j++) {
                System.out.print(fieldWithShips[j][i] + "\t");
            }
            System.out.println();
        }
    }
}
