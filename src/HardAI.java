import java.util.ArrayList;

public class HardAI implements Player {


    public void move(Board board) {
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        int bestScore = Integer.MIN_VALUE;
        ArrayList<Integer> bestMove = null;
        for (ArrayList<Integer> alist : board.getCells()) {
            x = alist.get(0);
            y = alist.get(1);
            board.set(x, y);
          //  board.printGrid();
            int result = minimax(board, false, board.oppositeSymbol());
            board.setBack(x, y);
           // board.printGrid();
            if (result > bestScore) {
                bestScore = result;
                bestMove = alist;
            }
        }
        board.set(bestMove.get(0), bestMove.get(1));
    }


    public int minimax(Board board, boolean maximizing, Symbol symbol) {
        if (board.checkState() != State.NotFinished) {

            return board.evaluate(symbol);
        }

        if (maximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (ArrayList<Integer> alist : board.getCells()) {
                int x = alist.get(0);
                int y = alist.get(1);
                board.set(x, y);
            //    board.printGrid();
                int result = minimax(board, false, symbol);
                board.setBack(x, y);
              //  board.printGrid();
                bestScore = Math.max(result, bestScore);

            }
            return bestScore;
        } else {
            int worstScore = Integer.MAX_VALUE;
            for (ArrayList<Integer> alist : board.getCells()) {
                int x = alist.get(0);
                int y = alist.get(1);
                board.set(x, y);
                //board.printGrid();
                int result = minimax(board, true, symbol);
                board.setBack(x, y);
                //board.printGrid();
                worstScore = Math.min(result, worstScore);

            }
            return worstScore;
        }

    }
}
