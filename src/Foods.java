import java.util.HashSet;
import java.util.Set;

public class Foods {
    private final HashSet<Block> foods;

    public Foods() {
        this.foods = new HashSet<>();
    }

    public void add(Block food) {
        foods.add(food);
    }

    public HashSet<Block> getFoods() {
        return foods;
    }

    public boolean isEmpty() {
        return foods.isEmpty();
    }

}
