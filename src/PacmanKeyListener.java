import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class PacmanKeyListener implements KeyListener {
    private final Block pacman;
    private final HashSet<Block> walls;
    private final Images images;

    public PacmanKeyListener(Block pacman, HashSet<Block> walls, Images images) {
        this.pacman = pacman;
        this.walls = walls;
        this.images = images;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        Direction dir = keyToDirection(e.getKeyCode());
        if (dir != null && !pacman.wouldCollide(dir, walls)) {
            pacman.setDirection(dir, walls);
            updatePacmanImage(dir);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}

    private Direction keyToDirection(int keyCode) {
        return switch (keyCode) {
            case KeyEvent.VK_UP -> Direction.UP;
            case KeyEvent.VK_DOWN -> Direction.DOWN;
            case KeyEvent.VK_LEFT -> Direction.LEFT;
            case KeyEvent.VK_RIGHT -> Direction.RIGHT;
            default -> null;
        };
    }

    private void updatePacmanImage(Direction dir) {
        switch (dir) {
            case UP -> pacman.image = images.pacmanUpImage;
            case DOWN -> pacman.image = images.pacmanDownImage;
            case LEFT -> pacman.image = images.pacmanLeftImage;
            case RIGHT -> pacman.image = images.pacmanRightImage;
        }
    }
}
