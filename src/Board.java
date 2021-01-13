import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private Symbol symbol;
    private boolean xIsNext;
    private Symbol[][] grid;
    private Scanner scanner;


    public Board() {
        grid = new Symbol[][]{{Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY},
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY},
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY}};
        scanner = new Scanner(System.in);
        xIsNext = true;

    }

    public void printGrid() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format("| %c %c %c |", grid[i][0].getSymbol(), grid[i][1].getSymbol(),
                    grid[i][2].getSymbol()));
        }
        System.out.println("---------");
    }

    public int countMarks() {
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == Symbol.X) {
                    xCount++;
                } else if (grid[i][j] == Symbol.O) {
                    oCount++;
                }
            }
        }
        return xCount + oCount;
    }

    public void set(int x, int y) {
        grid[x][y] = nextSymbol();
        xIsNext = !xIsNext;
    }

    public void setBack(int x, int y) {
        grid[x][y] = Symbol.EMPTY;
        xIsNext = !xIsNext;
    }

    public Symbol nextSymbol() {
        Symbol symbol = xIsNext ? Symbol.X : Symbol.O;
        return symbol;
    }

    public Symbol oppositeSymbol() {
        if (nextSymbol() == Symbol.X) {
            return Symbol.O;
        } else {
            return Symbol.X;
        }
    }

    public boolean checkNumbers(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        }
        return true;
    }

    public boolean checkIfEmpty(int x, int y) {
        if (grid[x][y] == Symbol.EMPTY) {
            return true;
        }
        return false;
    }

    public ArrayList<ArrayList<Integer>> getCells() {
        ArrayList<ArrayList<Integer>> cells = new ArrayList<>();

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++ ) {
                if (grid[x][y] == Symbol.EMPTY) {
                    cells.add(new ArrayList<>(Arrays.asList(x,y)));
                }
            }
        }
        return cells;
    }

    public State checkState() {
        Symbol symbol = checkWinner();
        if (symbol != null) {
            return switch (symbol) {
                case X -> State.Xwins;
                case O -> State.Owins;
                case EMPTY -> State.Draw;
            };
        }
        return State.NotFinished;
    }

    boolean willWin(int x, int y, Symbol symbol) {
        if (checkIfEmpty(x, y)) {
            Symbol before = grid[x][y];
            grid[x][y] = symbol;

            boolean won = checkWinner() == symbol;

            grid[x][y] = before;
            return won;
        }
        return false;
    }

    public Symbol checkWinner() {
        if (checkRow(Symbol.O) || checkColumn(Symbol.O) || checkDiag(Symbol.O)) {
            return Symbol.O;
        } else if (checkRow(Symbol.X) || checkColumn(Symbol.X) || checkDiag(Symbol.X)) {
            return Symbol.X;
        } else if (countMarks() == 9) {
            return Symbol.EMPTY;
        }
        return null;
    }

    public boolean checkRow(Symbol symbol) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumn(Symbol symbol) {
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiag(Symbol symbol) {
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] == symbol) {
            return true;
        } else if (grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] && grid[2][0] == symbol) {
            return true;
        }
        return false;
    }

    public int evaluate(Symbol symbol) {
        if (checkWinner() == symbol) {
            return 1;
        } else if (checkWinner() == oppositeSymbol()) {
            return -1;
        } else {
            return 0;
        }
    }
}



