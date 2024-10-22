package exercises;

import exercises.model.Data;
import exercises.model.FoodType;
import exercises.model.Person;
import exercises.utils.Asserts;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Exercise3GroupingPeople {
    // Tip: Before starting, go look up the types Person and FoodType in the exercises.model folder

    /**
     * Returns a map sending a food type to a list of people that have it as favorite.
     * @param people the list of people.
     * @return the map.
     */
    public static Map<FoodType, List<Person>> groupPeopleByFavoriteFood(List<Person> people) {
        // FIXME: implement using streams
        return Collections.emptyMap();
    }

    /**
     * Returns a map sending a food type to the oldest person that has it as favorite.
     * @param people the list of people.
     * @return the map.
     */
    public static Map<FoodType, Person> findOldestPersonWithEachFoodAsFavorite(List<Person> people) {
        // FIXME: implement using streams
        // Hint: there is some trickery involved to return Map<FoodType, Person>. A solution returning
        // Map<FoodType, Optional<Person>> is acceptable, but the tests won't work.
        return Collections.emptyMap();
    }

    /**
     * Returns a map sending a food type to a list of people's names that have it as favorite. Do not include names
     * of people who have allergies.
     * @param people the list of people.
     * @return the map.
     */
    public static Map<FoodType, List<String>> groupPeopleWithoutAllergiesByFavoriteFood(List<Person> people) {
        // FIXME: implement using streams
        return Collections.emptyMap();
    }

    /**
     * Returns a map sending a food type to the age of the oldest person that has it as favorite.
     * @param people the list of people.
     * @return the map.
     */
    public static Map<FoodType, Integer> findAgeOfOldestPersonWithEachFoodAsFavorite(List<Person> people) {
        // FIXME: implement using streams
        return Collections.emptyMap();
    }

    /**
     * Returns a map where the keys are the starting age of an age group, and the values are lists consisting of people
     * in the age group.
     * @param people the list of people.
     * @param sizeOfGroup the size of the group.
     * @return the map.
     */
    public static Map<FoodType, Integer> groupPeopleByAgeGroups(List<Person> people, int sizeOfGroup) {
        // FIXME: implement using streams
        // Hint: the question has a very short solution that plays with integer division, but alternatives can be tricky
        return Collections.emptyMap();
    }

    public static void main(String[] args) {
        Asserts.assertEqual(
                Map.of(
                        FoodType.MEAT, List.of(Data.CLAUDIA),
                        FoodType.GRAINS, List.of(Data.LUIS, Data.PATRICIA),
                        FoodType.FISH, List.of(Data.MARTA, Data.CLARA, Data.BEATRIZ),
                        FoodType.SWEETS, List.of(Data.LUCAS, Data.JAVIER, Data.BONIFACIA),
                        FoodType.VEGETABLES, List.of(Data.EUSTAQUIO)
                ),
                groupPeopleByFavoriteFood(Data.PEOPLE)
        );

        Asserts.assertEqual(
                Map.of(
                        FoodType.MEAT, Data.CLAUDIA,
                        FoodType.GRAINS, Data.LUIS,
                        FoodType.FISH, Data.BEATRIZ,
                        FoodType.SWEETS, Data.BONIFACIA,
                        FoodType.VEGETABLES, Data.EUSTAQUIO
                ),
                findOldestPersonWithEachFoodAsFavorite(Data.PEOPLE)
        );

        Asserts.assertEqual(
                Map.of(
                        FoodType.VEGETABLES, List.of("Eustaquio"),
                        FoodType.GRAINS, List.of("Patricia"),
                        FoodType.FISH, List.of("Marta", "Beatriz"),
                        FoodType.SWEETS, List.of("Lucas", "Javier")
                ),
                groupPeopleWithoutAllergiesByFavoriteFood(Data.PEOPLE)
        );

        Asserts.assertEqual(
                Map.of(
                        FoodType.MEAT, 30,
                        FoodType.GRAINS, 44,
                        FoodType.FISH, 58,
                        FoodType.SWEETS, 88,
                        FoodType.VEGETABLES, 90
                ),
                findAgeOfOldestPersonWithEachFoodAsFavorite(Data.PEOPLE)
        );

        Asserts.assertEqual(
                Map.of(
                        10, List.of(Data.LUCAS),
                        20, List.of(Data.CLARA, Data.PATRICIA),
                        30, List.of(Data.MARTA, Data.CLAUDIA, Data.JAVIER),
                        40, List.of(Data.LUIS),
                        50, List.of(Data.BEATRIZ),
                        80, List.of(Data.BONIFACIA),
                        90, List.of(Data.EUSTAQUIO)
                ),
                groupPeopleByAgeGroups(Data.PEOPLE, 10)
        );

        System.out.println("All tests succeeded");
    }
}
