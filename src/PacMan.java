import java.awt.*;
import javax.swing.*;

public class PacMan extends JPanel {
    final int rowCount;
    final int columnCount;
    final int titleSize;
    final int boardHeight;
    final int boardWidth;
    protected LoadMap loadMap;
    final Images images;
    final PaintComponent paint;


    PacMan(int rowCount, int columnCount, int titleSize, int boardWidth, int boardHeight){
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.titleSize = titleSize;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        images = new Images();
        loadMap = new LoadMap(images, rowCount, columnCount, titleSize);

        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.BLACK);

        loadMap.loadMap();
        paint = new PaintComponent(loadMap);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paint.draw(g);
    }

}