import java.awt.*;
import javax.swing.*;
import java.util.Set;

public class GameRenderer extends JPanel {
    private final Pacman pacman;
    private final Set<Block> ghosts;
    private final Set<Block> foods;
    private final Set<Block> walls;

    public GameRenderer(Pacman pacman, Set<Block> ghosts, Set<Block> foods, Set<Block> walls) {
        this.pacman = pacman;
        this.ghosts = ghosts;
        this.foods = foods;
        this.walls = walls;
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Walls
        for (Block wall : walls) {
            if (wall.image != null) {
                g.drawImage(wall.image, wall.x, wall.y, wall.width, wall.height, null);
            } else {
                g.setColor(Color.GRAY);
                g.fillRect(wall.x, wall.y, wall.width, wall.height);
            }
        }
        // Draw Foods
        g.setColor(Color.GREEN);
        for(Block food : foods)
        {
            g.fillRect(food.x, food.y, food.width, food.height);
        }

        // Draw Ghosts
        for (Block ghost : ghosts) {
            if (ghost.image != null) {
                g.drawImage(ghost.image, ghost.x, ghost.y, ghost.width, ghost.height, null);
            }
        }

        // Draw Pacman
        if (pacman != null && pacman.image != null) {
            g.drawImage(pacman.image, pacman.x, pacman.y, pacman.width, pacman.height, null);
        }
    }
}
