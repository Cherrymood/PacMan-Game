import java.awt.*;
import java.util.Set;

public class Pacman extends Block {

    public Pacman(Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
        updateVelocity();
    }

    public void setDirection(Direction newDirection, Set<Block> walls) {
        if (!wouldCollide(newDirection, walls)) {
            this.direction = newDirection;
            updateVelocity();
        }
    }

    public Direction getDirection() {
        return direction;
    }
}
