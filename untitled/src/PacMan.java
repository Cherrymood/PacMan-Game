import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;
import javax.swing.*;

public class PacMan extends JPanel {
    private int rowCount = 21;
    private int columnCount = 19;
    private int titleSize = 32;
    private int boardWidth = columnCount * titleSize;
    private int boardHeight = rowCount * titleSize;

    private Image wallImage;
    private Image blueGhostImage;
    private Image orangeGhostImage;
    private Image pinkGhostImage;
    private Image redGhostImage;

    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image pacmanRightImage;

    HashSet<Block> walls;
    HashSet<Block> foods;
    HashSet<Block> ghosts;
    Block packman;

    PacMan(){
        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.BLACK);

        wallImage = new ImageIcon(getClass().getResource("./pictures/wall.png")).getImage();
        blueGhostImage = new ImageIcon(getClass().getResource("./pictures/blueGhost.png")).getImage();
        orangeGhostImage = new ImageIcon(getClass().getResource("./pictures/orangeGhost.png")).getImage();
        pinkGhostImage = new ImageIcon(getClass().getResource("./pictures/pinkGhost.png")).getImage();
        redGhostImage = new ImageIcon(getClass().getResource("./pictures/redGhost.png")).getImage();

        pacmanUpImage = new ImageIcon(getClass().getResource("./pictures/pacmanUp.png")).getImage();
        pacmanDownImage = new ImageIcon(getClass().getResource("./pictures/pacmanDown.png")).getImage();
        pacmanLeftImage = new ImageIcon(getClass().getResource("./pictures/pacmanLeft.png")).getImage();
        pacmanRightImage = new ImageIcon(getClass().getResource("./pictures/pacmanRight.png")).getImage();
    }
}