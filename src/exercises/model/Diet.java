package exercises.model;

import java.util.Collections;
import java.util.Map;

public class Diet {
    private final Map<FoodType, Integer> foodConsumed;

    Diet(Map<FoodType, Integer> foodConsumed) {
        this.foodConsumed = foodConsumed;
    }

    public int getAmountConsumed(FoodType foodType) {
        return foodConsumed.getOrDefault(foodType, 0);
    }

    public Map<FoodType, Integer> getAllAmountsConsumed() {
        return Collections.unmodifiableMap(this.foodConsumed);
    }
}
