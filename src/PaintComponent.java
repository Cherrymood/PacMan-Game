import java.awt.*;
import java.util.HashSet;
import java.awt.Graphics;


public class PaintComponent extends PacMan{
    final Block pacman;
    final HashSet<Block> ghosts;
    final HashSet<Block> foods;
    final HashSet<Block> walls;

    // Constructor now takes LoadMap reference
    public PaintComponent(LoadMap loadMap) {
        this.loadMap = loadMap;
        this.pacman = loadMap.getPacman();
        this.ghosts = loadMap.getGhosts();
        this.foods = loadMap.getFoods();
        this.walls = loadMap.getWalls();
    }

    public void draw(Graphics g)
    {

        if (pacman != null) {
            g.drawImage(pacman.image, pacman.x, pacman.y, pacman.width, pacman.height, null);
        }

        for(Block ghost : ghosts)
        {
            g.drawImage(ghost.image, ghost.x, ghost.y, ghost.width, ghost.height, null);
        }
        for(Block wall : walls)
        {
            g.drawImage(wall.image, wall.x, wall.y, wall.width, wall.height, null);
        }
        g.setColor(Color.GREEN);
        for(Block food : foods)
        {
            g.fillRect(food.x, food.y, food.width, food.height);
        }
    }
}
