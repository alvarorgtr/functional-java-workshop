package exercises;

import exercises.model.FoodType;
import exercises.model.Person;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Exercise4Diets {
    // Tip: Before starting, go look up the types Diet, Person, and FoodType in the exercises.model folder

    /**
     * Returns a list of the names of vegetarians in the list. Vegetarians are those people whose diet includes no
     * meat and no fish.
     *
     * @param people the list of people.
     * @return the list.
     */
    public List<String> listNamesOfVegetarians(List<Person> people) {
        // FIXME: implement using streams
        return Collections.emptyList();
    }

    /**
     * Finds the most popular food type, that is, the one that has the greatest total amount consumed in the diets
     * of the people.
     *
     * @param people the list of people.
     * @return the map.
     */
    public FoodType mostPopularFoodType(List<Person> people) {
        // FIXME: implement using streams
        return FoodType.DAIRY;
    }

    /**
     * Returns the three people that consume the most food, in order. The amount of food consumed per person is
     * the total amount for all food types.
     *
     * @param people the list of people.
     * @return the list.
     */
    public List<Person> top3PeopleByFoodConsumed(List<Person> people) {
        // FIXME: implement using streams
        return Collections.emptyList();
    }

    /**
     * Returns a list of people that are allergic to a food, but are still eating it. Get them to the hospital!
     *
     * @param people the list of people.
     * @return the list.
     */
    public List<Person> unsafeAllergicPeople(List<Person> people) {
        // FIXME: implement using streams
        return Collections.emptyList();
    }

    /**
     * Returns the person with the most expensive diet.
     *
     * @param people the list of people.
     * @param prices the price for one unit of food of the given food type.
     * @return the person.
     */
    public Person mostExpensiveDiet(List<Person> people, Map<FoodType, Integer> prices) {
        // FIXME: implement using streams
        return null;
    }

    public static void main(String[] args) {

    }
}
