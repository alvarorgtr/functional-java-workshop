package exercises;

import exercises.model.FoodType;
import exercises.model.Person;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Exercise2FoodAndAllergies {
    // Tip: Before starting, go look up the types Person and FoodType in the exercises.model folder

    /**
     * Returns the names of the people in the list.
     * @param people the list of people.
     * @return the list of people names.
     */
    public static List<String> getPeopleNames(List<Person> people) {
        // FIXME: implement using streams
        // Extra: can you do it with method references instead of lambdas?
        return Collections.emptyList();
    }

    /**
     * Returns the names of the people in the list, all together in a single string.
     * E.g. [Person{name=Alvaro}, Person{name=Peter}] => "Alvaro, Peter".
     * @param people the list of people.
     * @return the string containing people names.
     */
    public static String getCommaSeparatedPeopleNames(List<Person> people) {
        // FIXME: implement using streams
        return "";
    }

    /**
     * Returns the names of all people that are of age (>= 18), sorted alphabetically.
     * @param people the list of people.
     * @return the list of names of people with allergies.
     */
    public static List<String> getNamesOfPeopleOfAgeSortedAlphabetically(List<Person> people) {
        // FIXME: implement using streams
        return Collections.emptyList();
    }

    /**
     * Returns all people that have an allergy.
     * @param people the list of people.
     * @return the list of people with allergies.
     */
    public static List<Person> getPeopleWithAllergies(List<Person> people) {
        // FIXME: implement using streams
        return Collections.emptyList();
    }

    /**
     * Returns the top n oldest people that have no allergies, sorted from the oldest.
     * @param people the list of people.
     * @param n how many people to return.
     * @return the list of people without allergies.
     */
    public static List<Person> getTopNOldestPeopleWithAllergies(List<Person> people, int n) {
        // FIXME: implement using streams
        return Collections.emptyList();
    }

    /**
     * Finds out if the given food type is the favorite of somebody in the list.
     * @param people the list of people.
     * @param foodType the food type to check.
     * @return true if the food type is somebody's favorite
     */
    public static boolean isFoodSomebodysFavorite(List<Person> people, FoodType foodType) {
        // FIXME: implement using streams
        // Hint: check out the anyMatch() method for streams
        return false;
    }

    /**
     * Finds out how many people in the list have a given food as favorite.
     * @param people the list of people.
     * @param foodType the food type to check.
     * @return the number of people having that food as their favorite.
     */
    public static int countPeopleHavingFoodAsFavorite(List<Person> people, FoodType foodType) {
        // FIXME: implement using streams
        // Extra: can you find two different ways to do it, both using streams?
        return 0;
    }

    /**
     * Finds out a set of foods that at least one person is allergic to.
     * @param people the list of people.
     * @return the set of food types that at least one person is allergic to.
     */
    public Set<FoodType> findFoodsThatTriggerAnyAllergies(List<Person> people) {
        // FIXME: implement using streams
        // Hint: check out the .flatMap() method for streams
        return Set.of();
    }

    public static void main(String[] args) {

    }
}
