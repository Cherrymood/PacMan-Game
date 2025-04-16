import java.awt.*;
import java.util.HashSet;

public class Pacman extends Block {
    public static final int TILE_SIZE = 32; // Adjust as needed
    private Direction direction = Direction.LEFT;

    public Pacman(Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
        updateVelocity();
    }

    public void setDirection(Direction newDirection, HashSet<Block> walls) {
        if (!wouldCollide(newDirection, walls)) {
            this.direction = newDirection;
            updateVelocity();
        }
    }

    public Direction getDirection() {
        return direction;
    }

    private void updateVelocity() {
        switch (direction) {
            case UP -> { velocityX = 0; velocityY = -TILE_SIZE / 4; }
            case DOWN -> { velocityX = 0; velocityY = TILE_SIZE / 4; }
            case LEFT -> { velocityX = -TILE_SIZE / 4; velocityY = 0; }
            case RIGHT -> { velocityX = TILE_SIZE / 4; velocityY = 0; }
        }
    }

    public boolean wouldCollide(Direction testDirection, HashSet<Block> walls) {
        int testX = x, testY = y;
        switch (testDirection) {
            case UP -> testY -= TILE_SIZE / 4;
            case DOWN -> testY += TILE_SIZE / 4;
            case LEFT -> testX -= TILE_SIZE / 4;
            case RIGHT -> testX += TILE_SIZE / 4;
        }
        Block testBlock = new Block(null, testX, testY, width, height);
        for (Block wall : walls) {
            if (testBlock.collidesWith(wall)) return true;
        }
        return false;
    }

    public void move(HashSet<Block> walls) {
        int prevX = x, prevY = y;
        x += velocityX;
        y += velocityY;
        for (Block wall : walls) {
            if (this.collidesWith(wall)) {
                x = prevX;
                y = prevY;
                break;
            }
        }
    }
}
