import java.util.HashSet;
import java.util.Set;

public class Ghosts {
    private final HashSet<Block> ghosts; // Use the Set interface for flexibility

    public Ghosts() {
        this.ghosts = new HashSet<>();
    }

    public void add(Block ghost) {
        ghosts.add(ghost);
    }

    public HashSet<Block> getGhosts() {
        return ghosts;
    }

}