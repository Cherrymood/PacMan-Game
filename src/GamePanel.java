import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
    private final Board board;
    private final GameRenderer renderer;

    public GamePanel(int rowCount, int columnCount, int tileSize, int boardWidth, int boardHeight) {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);
        setFocusable(true);
        Images images = new Images();
        board = new Board(images, rowCount, columnCount, tileSize);
        board.createBoard();
        renderer = new GameRenderer(board.getPacman(), board.getGhosts(), board.getFoods(), board.getWalls());
        PacmanKeyListener directionHandler = new PacmanKeyListener(board.getPacman(), board.getWalls(), images);
        addKeyListener(directionHandler);
        Timer gameLoop = new Timer(50, this);
        ResetGame reset = new ResetGame(board);

        gameLoop.start();
        reset.reset();
    }

    @Override
    protected void paintComponent(Graphics g) {
        renderer.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        board.getPacman().move(board.getWalls());
        repaint();
    }
}
