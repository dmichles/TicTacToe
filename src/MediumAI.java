import java.util.ArrayList;

public class MediumAI extends EasyAI {

    public void move(Board board) {
        Symbol symbol = board.nextSymbol();
        System.out.println(String.format("Making move level \"medium\""));

        if (checkNextTurn(board, symbol)) {
            System.out.println("true");
            return;
        } else if (checkNextTurn(board, board.oppositeSymbol())) {
            System.out.println("opposite");
            return;
        } else {
            System.out.println("random");
            randMove(board);
        }
    }

    public boolean checkNextTurn(Board board, Symbol symbol) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.willWin(i,j, symbol)) {
                    board.set(i,j);
                    return true;
                }
            }
        }
    return false;
    }

}
