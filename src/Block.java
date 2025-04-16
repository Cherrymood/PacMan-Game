import java.awt.*;

public class Block {
    int x;
    int y;
    final int width;
    final int height;
    Image image;

    final int startX;
    final int startY;
    final int tileSize;
    public int velocityX = 0;
    public int velocityY = 0;

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

    public boolean collidesWith(Block other) {
        return x < other.x + other.width &&
                x + width > other.x &&
                y < other.y + other.height &&
                y + height > other.y;
    }
}
