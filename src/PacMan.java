import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PacMan extends JPanel implements ActionListener {
    final int rowCount;
    final int columnCount;
    final int titleSize;
    final int boardHeight;
    final int boardWidth;
    protected LoadMap loadMap;
    final Images images;
    final PaintComponent paint;
    final Timer gameloop;
    private final Direction directionHandler;

    PacMan(int rowCount, int columnCount, int titleSize, int boardWidth, int boardHeight){
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.titleSize = titleSize;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        images = new Images();
        loadMap = new LoadMap(images, rowCount, columnCount, titleSize);
        setFocusable(true);

        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.BLACK);

        loadMap.loadMap();
        paint = new PaintComponent(loadMap);

        directionHandler = new Direction(paint.pacman, paint.walls, images);
        addKeyListener(directionHandler);

        gameloop = new Timer(50, this);
        gameloop.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paint.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paint.pacman.move(paint.walls, paint.pacman);
        repaint();
    }

}