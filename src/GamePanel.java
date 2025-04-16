import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
    private final Board board;
    private final Images images;
    private final GameRenderer renderer;
    private final Timer gameLoop;
    private final PacmanKeyListener directionHandler;

    public GamePanel(int rowCount, int columnCount, int tileSize, int boardWidth, int boardHeight) {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);
        setFocusable(true);

        images = new Images();
        board = new Board(images, rowCount, columnCount, tileSize);
        board.createBoard();

        renderer = new GameRenderer(board.getPacman(), board.getGhosts(), board.getFoods(), board.getWalls());

        directionHandler = new PacmanKeyListener(board.getPacman(), board.getWalls(), images);
        addKeyListener(directionHandler);

        gameLoop = new Timer(50, this);
        gameLoop.start();
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
