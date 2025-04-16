import java.util.Random;

public class ResetGame {
    private final Foods foods; // Assuming you have a Food class
    private Direction[] directions;
    private final Board board;

    public ResetGame(Board board) {
        this.foods = board.foods;
        this.board = board;
    }

    public void reset() {

        if (foods.isEmpty()) {
            board.createBoard();
        }
    }
}
