import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class PacMan extends JPanel implements ActionListener, KeyListener {
    final int rowCount;
    final int columnCount;
    final int titleSize;
    final int boardHeight;
    final int boardWidth;
    protected LoadMap loadMap;
    final Images images;
    final PaintComponent paint;
    final Timer gameloop;


    PacMan(int rowCount, int columnCount, int titleSize, int boardWidth, int boardHeight){
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.titleSize = titleSize;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        images = new Images();
        loadMap = new LoadMap(images, rowCount, columnCount, titleSize);
        addKeyListener(this);
        setFocusable(true);

        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.BLACK);

        loadMap.loadMap();
        paint = new PaintComponent(loadMap);
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
        paint.pacman.move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                paint.pacman.updateDirection('D');
                break;

            case KeyEvent.VK_UP:
                paint.pacman.updateDirection('U');
                break;

            case KeyEvent.VK_LEFT:
                paint.pacman.updateDirection('L');
                break;

            case KeyEvent.VK_RIGHT:
                paint.pacman.updateDirection('R');
                break;
        }
    }
}