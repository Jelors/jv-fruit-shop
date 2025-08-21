package storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    // public static final List<FruitTransaction> fruitDbInput = new ArrayList<>();
    private static final Map<String, Integer> fruitDbResult = new HashMap<>();

    public static Map<String, Integer> getFruitDbResult() {
        return fruitDbResult;
    }
}
