import java.awt.*;
import javax.swing.*;

public class PacMan extends JPanel {
    private int rowCount = 21;
    private int columnCount = 19;
    private int tileSize = 32;
    private int boardWidth = columnCount * tileSize;
    private int boardHeight = rowCount * tileSize;
    private LoadMap loadMap;
    private Images images;


    PacMan(){
        images = new Images();
        loadMap = new LoadMap(images);

        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.BLACK);

        loadMap.loadMap();

    }
}