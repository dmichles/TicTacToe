import java.util.Scanner;

public class RealUser implements Player {
    Scanner scanner;

    public RealUser() {
        scanner = new Scanner(System.in);

    }

    public void move(Board board) {
        String xs = " ";
        String ys = " ";
        int x, y;
        String[] coordinates;

        while (true) {

            System.out.print("Enter the coordinates:");
            coordinates = scanner.nextLine().split(" ");

            xs = coordinates[0];

            if (coordinates.length > 1) {
                ys = coordinates[1];
            }

            if (!xs.matches("[0-9]+") || !ys.matches("[0-9]+")) {
                System.out.println("You should enter numbers!");
                continue;
            }
            x = 3 - Integer.parseInt(ys);
            y = Integer.parseInt(xs) - 1;

            if (!board.checkNumbers(x,y)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (!board.checkIfEmpty(x,y)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            break;
        }
        board.set(x,y);

    }
}
