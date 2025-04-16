import java.util.HashSet;
import java.util.Set;

public class Board {

    final String[] tileMap = {
            "XXXXXXXXXXXXXXXXXXX",
            "X        X        X",
            "X XX XXX X XXX XX X",
            "X                 X",
            "X XX X XXXXX X XX X",
            "X    X       X    X",
            "XXXX XXXX XXXX XXXX",
            "OOOX X       X XOOO",
            "XXXX X XXrXX X XXXX",
            "O       bpo       O",
            "XXXX X XXXXX X XXXX",
            "OOOX X       X XOOO",
            "XXXX X XXXXX X XXXX",
            "X        X        X",
            "X XX XXX X XXX XX X",
            "X  X     P     X  X",
            "XX X X XXXXX X X XX",
            "X    X   X   X    X",
            "X XXXXXX X XXXXXX X",
            "X                 X",
            "XXXXXXXXXXXXXXXXXXX"
    };

    final int rowCount;
    final int columnCount;
    final int tileSize;

    final Walls walls;
    final Foods foods;
    final Ghosts ghosts;
    private Pacman pacman;

    final Images images;

    public Board(Images images, int rowCount, int columnCount, int tileSize ) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.tileSize = tileSize;
        this.images = images;
        walls = new Walls();
        foods = new Foods();
        ghosts = new Ghosts();
    }

    public void createBoard(){

        for (int r = 0; r < rowCount; r++) {
            String row = tileMap[r];
            for (int c = 0; c < columnCount; c++) {
                char tileMapChar = row.charAt(c);

                int x = c * tileSize;
                int y = r * tileSize;

                switch (tileMapChar) {
                    case 'X': // Wall
                        walls.add(new Block(images.wallImage, x, y, tileSize, tileSize));
                        break;

                    case 'b': // Blue Ghost
                        ghosts.add(new Block(images.blueGhostImage, x, y, tileSize, tileSize));
                        break;

                    case 'o': // Orange Ghost
                        ghosts.add(new Block(images.orangeGhostImage, x, y, tileSize, tileSize));
                        break;

                    case 'p': // Pink Ghost
                        ghosts.add(new Block(images.pinkGhostImage, x, y, tileSize, tileSize));
                        break;

                    case 'r': // Red Ghost
                        ghosts.add(new Block(images.redGhostImage, x, y, tileSize, tileSize));
                        break;

                    case 'P': // Pac-Man
                        pacman = new Pacman(images.pacmanRightImage, x, y, tileSize, tileSize);
                        break;

                    case ' ': // Food dot
                        foods.add(new Block(null, x + 14, y + 14, 4, 4));
                        break;
                    // Optional: default case for unknown characters
                    default:
                        break;
                }
            }
        }
    }

    public Pacman getPacman() {
        return pacman;
    }

    public HashSet<Block> getGhosts() {
        return ghosts.getGhosts();
    }

    public HashSet<Block> getFoods() {
        return foods.getFoods();
    }

    public HashSet<Block> getWalls() {
        return walls.getWallBlocks();
    }

}