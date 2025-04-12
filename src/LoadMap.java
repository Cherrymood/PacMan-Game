import java.util.HashSet;

public class LoadMap {

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

    final HashSet<Block> walls;
    final HashSet<Block> foods;
    final HashSet<Block> ghosts;
    private Block pacman;

    final Images images;

    public LoadMap(Images images, int rowCount, int columnCount, int tileSize ) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.tileSize = tileSize;
        this.images = images;
        walls = new HashSet<Block>();
        foods = new HashSet<Block>();
        ghosts = new HashSet<Block>();
    }

    public void loadMap(){

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
                        pacman = new Block(images.pacmanRightImage, x, y, tileSize, tileSize);
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
    // Getter methods
    public HashSet<Block> getWalls() { return walls; }
    public HashSet<Block> getFoods() { return foods; }
    public HashSet<Block> getGhosts() { return ghosts; }
    public Block getPacman() { return pacman; }
}