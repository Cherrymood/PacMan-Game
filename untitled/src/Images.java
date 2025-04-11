import javax.swing.*;
import java.awt.*;

public class Images {
    Image wallImage;
    Image blueGhostImage;
    Image orangeGhostImage;
    Image pinkGhostImage;
    Image redGhostImage;

    Image pacmanUpImage;
    Image pacmanDownImage;
    Image pacmanLeftImage;
    Image pacmanRightImage;

    public Images()
    {
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
