import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class EasyAI implements Player {

    public void randMove(Board board) {
        ArrayList<Integer> cell = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.clear();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.checkIfEmpty(i, j)) {
                    list.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                    count++;
                }
            }
        }
        Random rand = new Random();
        int randIndex = rand.nextInt(count);
        int x = list.get(randIndex).get(0);
        int y = list.get(randIndex).get(1);
        cell.add(x);
        cell.add(y);
        board.set(cell.get(0),cell.get(1));
    }
    public void move(Board board) {
        ArrayList<Integer> cell = new ArrayList<>();
        System.out.println(String.format("Making move level \"easy\""));
        randMove(board);

    }
}