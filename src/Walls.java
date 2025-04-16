import java.util.HashSet;
import java.util.Set;

public class Walls {
    private final HashSet<Block> wallBlocks;

    public Walls() {
        this.wallBlocks = new HashSet<>();
    }

    // Add a wall block
    public void add(Block wall) {
        wallBlocks.add(wall);
    }

    // Get all wall blocks
    public HashSet<Block> getWallBlocks() {
        return wallBlocks;
    }
}
