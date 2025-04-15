import java.awt.*;
import java.util.HashSet;

public class Block {
    int x;
    int y;
    final int width;
    final int height;
    Image image;

    final int startX;
    final int startY;
    final int tileSize;
    private char direction = 'U';
    private int velocityX = 0;
    private int velocityY = 0;

    public Block(Image image, int x, int y, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startX = x;
        this.startY = y;
        this.tileSize = width;
    }

    // New method to check movement possibility
    public boolean wouldCollide(char direction, HashSet<Block> walls) {
        int testX = x;
        int testY = y;

        // Calculate test position
        switch(direction) {
            case 'U' -> testY -= tileSize / 4;
            case 'D' -> testY += tileSize / 4;
            case 'L' -> testX -= tileSize / 4;
            case 'R' -> testX += tileSize / 4;
        }

        // Create test block for collision check
        Block testBlock = new Block(null, testX, testY, width, height);

        // Check against walls
        for(Block wall : walls) {
            if(collision(testBlock, wall)) {
                return true;
            }
        }
        return false;
    }

    public void updateDirection(char direction, HashSet<Block> walls) {
        // Check if new direction is possible before updating
        if(!wouldCollide(direction, walls)) {
            this.direction = direction;
            updateVelocity();
        }
    }

    private void updateVelocity() {
        switch(this.direction) {
            case 'U' -> {
                velocityX = 0;
                velocityY = -tileSize / 4;
            }
            case 'D' -> {
                velocityX = 0;
                velocityY = tileSize / 4;
            }
            case 'L' -> {
                velocityX = -tileSize / 4;
                velocityY = 0;
            }
            case 'R' -> {
                velocityX = tileSize / 4;
                velocityY = 0;
            }
        }
    }

    public void move(HashSet<Block> walls, Block pacman) {
        // Store previous position
        int prevX = pacman.x;
        int prevY = pacman.y;

        pacman.x += pacman.velocityX;
        pacman.y += pacman.velocityY;

        // Check collisions after movement
        for(Block wall : walls) {
            if(collision(pacman, wall)) {
                pacman.x = prevX;
                pacman.y = prevY;
                break;
            }
        }
    }

    public boolean collision(Block a, Block b) {
        return a.x < b.x + b.width &&
                a.x + a.width > b.x &&
                a.y < b.y + b.height &&
                a.y + a.height > b.y;
    }
}
