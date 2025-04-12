import java.awt.*;
import java.util.HashSet;

public class Block {
    int x;
    int y;
    final int width;
    final int height;
    final Image image;

    final int startX;
    final int startY;
    final int tileSize;
    private char direction = 'U';
    private int velocityX = 0;
    private int velocityY = 0;

    public Block(Image image, int x, int y, int width, int height){
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startX = x;
        this.startY = y;
        this.tileSize = width;
    }

    public void updateDirection(char direction){
        this.direction = direction;
        updateVelocity();
    }

    private void updateVelocity()
    {
        switch(this.direction) {
            case 'U':
                this.velocityX = 0;
                this.velocityY = -tileSize / 4;
                break;
            case 'D':
                this.velocityX = 0;
                this.velocityY = tileSize / 4;
                break;
            case 'L':
                this.velocityX = -tileSize / 4;
                this.velocityY = 0;
                break;
            case 'R':
                this.velocityX = tileSize / 4;
                this.velocityY = 0;
                break;
        }
    }

    public void move() {
        this.x += this.velocityX;
        this.y += this.velocityY;
    }
}
