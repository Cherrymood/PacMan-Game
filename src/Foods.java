import java.util.HashSet;
import java.util.Set;

public class Foods {
    private final HashSet<Block> foods;

    public Foods() {
        this.foods = new HashSet<>();
    }

    // Add a food block
    public void add(Block food) {
        foods.add(food);
    }

    // Get all food blocks
    public HashSet<Block> getFoods() {
        return foods;
    }

    // Check if there are any foods left
    public boolean isEmpty() {
        return foods.isEmpty();
    }
}
