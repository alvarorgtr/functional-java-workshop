package exercises;

import exercises.model.FoodType;
import exercises.model.Person;

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
     * in the age group .
     * @param people the list of people.
     * @return the map.
     */
    public static Map<FoodType, Integer> groupPeopleByAgeGroups(List<Person> people, int sizeOfGroup) {
        // FIXME: implement using streams
        return Collections.emptyMap();
    }

    public static void main(String[] args) {

    }
}
