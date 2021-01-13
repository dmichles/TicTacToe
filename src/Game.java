import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
    Scanner scanner;
    Player[] players;
    String command = "";

    public Game() {
        scanner = new Scanner(System.in);
        players = new Player[2];
        doCommands();
    }

    public void doCommands() {
        while (true) {
            System.out.print("Input command: ");
            String command = scanner.nextLine();
            String command1;
            String command2;
            String command3;
            Scanner input = new Scanner(command);
            if (command.equals("exit")) {
                break;
            } else if ((command1 = input.next()).equals("start")) {
                if (input.hasNext(Pattern.compile("easy|hard|medium|user"))) {
                    command2 = input.next();
                } else {
                    System.out.println("Bad parameters");
                    continue;
                }
                if (input.hasNext(Pattern.compile("easy|hard|medium|user"))) {
                    command3 = input.next();
                } else {
                    System.out.println("Bad parameters");
                    continue;
                }
            } else {
                System.out.println("Bad parameters");
                continue;
            }
            players[0] = Player.of(command2);
            players[1] = Player.of(command3);
            loopgame(players[0], players[1]);
        }
    }

    public void loopgame(Player xPlayer, Player oPlayer) {
        Board board = new Board();
        board.printGrid();

        while (true) {

            xPlayer.move(board);
            board.printGrid();
            if (board.checkState() != State.NotFinished) {
                System.out.println(board.checkState().getState());
                break;
            }

            oPlayer.move(board);
            board.printGrid();
            if (board.checkState() != State.NotFinished) {
                System.out.println(board.checkState().getState());
                break;
            }
        }
    }
}
