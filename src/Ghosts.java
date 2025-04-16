import java.util.HashSet;
import java.util.Set;

public class Ghosts {
    private final HashSet<Block> ghosts; // Use the Set interface for flexibility

    public Ghosts() {
        this.ghosts = new HashSet<>();
    }

    // Add a ghost block
    public void add(Block ghost) {
        ghosts.add(ghost);
    }

    // Get all ghost blocks
    public HashSet<Block> getGhosts() {
        return ghosts;
    }

    // Check if there are any ghosts
    public boolean isEmpty() {
        return ghosts.isEmpty();
    }
}