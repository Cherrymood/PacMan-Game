import java.awt.*;
import java.util.HashSet;

public class Block {
    protected int x;
    protected int y;
    protected final int width;
    protected final int height;
    protected final int startX;
    protected final int startY;
    protected final int tileSize;
    protected int velocityX = 0;
    protected int velocityY = 0;
    protected Direction direction = Direction.LEFT;
    protected Image image;

    public Block(Image image, int x, int y, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startX = x;
        this.startY = y;
        this.tileSize = width; // assuming square blocks
    }

    public boolean collidesWith(Block other) {
        return x < other.x + other.width &&
                x + width > other.x &&
                y < other.y + other.height &&
                y + height > other.y;
    }

    public void reset() {
        this.x = this.startX;
        this.y = this.startY;
    }

    public void setDirection(Direction newDirection, HashSet<Block> walls) {
        this.direction = newDirection;
        updateVelocity();
    }

    protected void updateVelocity() {
        int speed = tileSize / 4;
        switch (direction) {
            case UP -> { velocityX = 0; velocityY = -speed; }
            case DOWN -> { velocityX = 0; velocityY = speed; }
            case LEFT -> { velocityX = -speed; velocityY = 0; }
            case RIGHT -> { velocityX = speed; velocityY = 0; }
        }
    }

    public void move(java.util.Set<Block> walls) {
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

    public boolean wouldCollide(Direction testDirection, java.util.Set<Block> walls) {
        int speed = tileSize / 4;
        int testX = x, testY = y;
        switch (testDirection) {
            case UP -> testY -= speed;
            case DOWN -> testY += speed;
            case LEFT -> testX -= speed;
            case RIGHT -> testX += speed;
        }
        Block testBlock = new Block(null, testX, testY, width, height);
        for (Block wall : walls) {
            if (testBlock.collidesWith(wall)) return true;
        }
        return false;
    }

}
