package exercises.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Data {
    private static Diet generateDiet(int sweets, int vegetables, int meat, int fish, int grains, int dairy) {
        return new Diet(Map.of(
                FoodType.SWEETS, sweets,
                FoodType.VEGETABLES, vegetables,
                FoodType.MEAT, meat,
                FoodType.FISH, fish,
                FoodType.GRAINS, grains,
                FoodType.DAIRY, dairy
        ));
    }

    public static Person MARTA = new Person("Marta", 36, FoodType.FISH, Collections.emptySet(), generateDiet(1, 5, 1, 4, 2, 1));
    public static Person LUCAS = new Person("Lucas", 10, FoodType.SWEETS, Collections.emptySet(), generateDiet(2, 2, 4, 3, 2, 3));
    public static Person CLARA = new Person("Clara", 27, FoodType.FISH, Set.of(FoodType.GRAINS), generateDiet(4, 5, 1, 1, 0, 2));
    public static Person LUIS = new Person("Luis", 44, FoodType.GRAINS, Set.of(FoodType.DAIRY), generateDiet(2, 4, 1, 3, 2, 0));
    public static Person EUSTAQUIO = new Person("Eustaquio", 90, FoodType.VEGETABLES, Collections.emptySet(), generateDiet(2, 3, 1, 1, 2, 1));
    public static Person PATRICIA = new Person("Patricia", 22, FoodType.GRAINS, Collections.emptySet(), generateDiet(2, 7, 0, 0, 3, 2));
    public static Person CLAUDIA = new Person("Claudia", 30, FoodType.MEAT, Set.of(FoodType.SWEETS, FoodType.DAIRY), generateDiet(0, 4, 2, 3, 3, 0));
    public static Person BEATRIZ = new Person("Beatriz", 58, FoodType.FISH, Collections.emptySet(), generateDiet(1, 0, 1, 4, 3, 3));
    public static Person JAVIER = new Person("Javier", 33, FoodType.SWEETS, Collections.emptySet(), generateDiet(3, 4, 0, 0, 6, 1));
    public static Person BONIFACIA = new Person("Bonifacia", 88, FoodType.SWEETS, Set.of(FoodType.SWEETS), generateDiet(1, 4, 0, 2, 1, 1));

    public static List<Person> PEOPLE = List.of(MARTA, LUCAS, CLARA, LUIS, EUSTAQUIO, PATRICIA, CLAUDIA, BEATRIZ, JAVIER, BONIFACIA);

    public static Map<FoodType, Integer> PRICES = Map.of(
            FoodType.SWEETS, 3,
            FoodType.VEGETABLES, 3,
            FoodType.MEAT, 5,
            FoodType.FISH, 4,
            FoodType.GRAINS, 2,
            FoodType.DAIRY, 2
    );
}
