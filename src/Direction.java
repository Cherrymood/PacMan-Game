import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class Direction implements KeyListener {
    private final Block pacman;
    private final HashSet<Block> walls;
    private final Images images;

    public Direction(Block pacman, HashSet<Block> walls, Images images) {
        this.pacman = pacman;
        this.walls = walls;
        this.images = images;
    }

    // Add this method to register listener with actual component
    public void registerToComponent(java.awt.Component comp) {
        comp.addKeyListener(this);
        comp.setFocusable(true);
        comp.requestFocusInWindow();
    }

    public enum Movement {
        UP('U', KeyEvent.VK_UP),
        DOWN('D', KeyEvent.VK_DOWN),
        LEFT('L', KeyEvent.VK_LEFT),
        RIGHT('R', KeyEvent.VK_RIGHT);

        private final char code;
        private final int keyCode;

        Movement(char code, int keyCode) {
            this.code = code;
            this.keyCode = keyCode;
        }

        public char getCode() { return code; }
        public int getKeyCode() { return keyCode; }

        public static Movement fromKeyCode(int keyCode) {
            for (Movement dir : values()) {
                if (dir.keyCode == keyCode) return dir;
            }
            return null;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        Movement dir = Movement.fromKeyCode(e.getKeyCode());
        if (dir != null) {
            char newDirection = dir.getCode();
            // First check if movement is possible
            if (!pacman.wouldCollide(newDirection, walls)) {
                pacman.updateDirection(newDirection, walls);
                updatePacmanImage(dir);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    private void updatePacmanImage(Movement dir) {
        switch(dir) {
            case UP -> pacman.image = images.pacmanUpImage;
            case DOWN -> pacman.image = images.pacmanDownImage;
            case LEFT -> pacman.image = images.pacmanLeftImage;
            case RIGHT -> pacman.image = images.pacmanRightImage;
        }
    }
}