package exercises;

import exercises.model.Data;
import exercises.model.FoodType;
import exercises.model.Person;
import exercises.utils.Asserts;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise2FoodAndAllergies {
    // Tip: Before starting, go look up the types Person and FoodType in the exercises.model folder

    /**
     * Returns the names of the people in the list.
     * @param people the list of people.
     * @return the list of people names.
     */
    public static List<String> getPeopleNames(List<Person> people) {
        return people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    /**
     * Returns the names of the people in the list, all together in a single string.
     * E.g. [Person{name=Alvaro}, Person{name=Peter}] => "Alvaro, Peter".
     * @param people the list of people.
     * @return the string containing people names.
     */
    public static String getCommaSeparatedPeopleNames(List<Person> people) {
        return people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
    }

    /**
     * Returns the names of all people that are of age (>= 18), sorted alphabetically.
     * @param people the list of people.
     * @return the list of names of people with allergies.
     */
    public static List<String> getNamesOfPeopleOfAgeSortedAlphabetically(List<Person> people) {
        return people.stream()
                .filter(p -> p.getAge() >= 18)
                .map(Person::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Returns all people that have an allergy.
     * @param people the list of people.
     * @return the list of people with allergies.
     */
    public static List<Person> getPeopleWithAllergies(List<Person> people) {
        return people.stream()
                .filter(p -> !p.getAllergies().isEmpty())
                .collect(Collectors.toList());
    }

    /**
     * Returns the top n oldest people that have no allergies, sorted from the oldest.
     * @param people the list of people.
     * @param n how many people to return.
     * @return the list of people without allergies.
     */
    public static List<Person> getTopNOldestPeopleWithAllergies(List<Person> people, int n) {
        return people.stream()
                .filter(p -> !p.getAllergies().isEmpty())
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    /**
     * Finds out if the given food type is the favorite of somebody in the list.
     * @param people the list of people.
     * @param foodType the food type to check.
     * @return true if the food type is somebody's favorite
     */
    public static boolean isFoodSomebodysFavorite(List<Person> people, FoodType foodType) {
        return people.stream()
                .map(Person::getFavouriteFood)
                .anyMatch(foodType::equals);


        /* Also valid (shorter but a bit more difficult to read!)
        return people.stream()
                .anyMatch(p -> foodType.equals(p.getFavouriteFood()));
         */
    }

    /**
     * Finds out how many people in the list have a given food as favorite.
     * @param people the list of people.
     * @param foodType the food type to check.
     * @return the number of people having that food as their favorite.
     */
    public static long countPeopleHavingFoodAsFavorite(List<Person> people, FoodType foodType) {
        return people.stream()
                .map(Person::getFavouriteFood)
                .filter(foodType::equals)
                .count();
    }

    /**
     * Finds out a set of foods that at least one person is allergic to.
     * @param people the list of people.
     * @return the set of food types that at least one person is allergic to.
     */
    public static Set<FoodType> findFoodsThatTriggerAnyAllergies(List<Person> people) {
        return people.stream()
                .flatMap(p -> p.getAllergies().stream())
                .collect(Collectors.toSet());
    }


    public static void main(String[] args) {
        Asserts.assertEqual(
                List.of("Marta", "Lucas", "Clara", "Luis", "Eustaquio", "Patricia", "Claudia", "Beatriz", "Javier", "Bonifacia"),
                getPeopleNames(Data.PEOPLE)
        );

        Asserts.assertEqual(
                "Marta, Lucas, Clara, Luis, Eustaquio, Patricia, Claudia, Beatriz, Javier, Bonifacia",
                getCommaSeparatedPeopleNames(Data.PEOPLE)
        );

        Asserts.assertEqual(
                List.of("Beatriz", "Bonifacia", "Clara", "Claudia", "Eustaquio", "Javier", "Luis", "Marta", "Patricia"),
                getNamesOfPeopleOfAgeSortedAlphabetically(Data.PEOPLE)
        );

        Asserts.assertEqual(
                Stream.of(2, 3, 6, 9).map(i -> Data.PEOPLE.get(i)).collect(Collectors.toList()),
                getPeopleWithAllergies(Data.PEOPLE)
        );

        Asserts.assertEqual(Collections.emptyList(), getTopNOldestPeopleWithAllergies(Data.PEOPLE, 0));
        Asserts.assertEqual(
                Stream.of(9, 3).map(i -> Data.PEOPLE.get(i)).collect(Collectors.toList()),
                getTopNOldestPeopleWithAllergies(Data.PEOPLE, 2)
        );

        Asserts.assertEqual(true, isFoodSomebodysFavorite(Data.PEOPLE, FoodType.SWEETS));
        Asserts.assertEqual(false, isFoodSomebodysFavorite(Data.PEOPLE, FoodType.DAIRY));

        Asserts.assertEqual(3L, countPeopleHavingFoodAsFavorite(Data.PEOPLE, FoodType.SWEETS));
        Asserts.assertEqual(1L, countPeopleHavingFoodAsFavorite(Data.PEOPLE, FoodType.MEAT));

        Asserts.assertEqual(
                Set.of(FoodType.GRAINS, FoodType.DAIRY, FoodType.SWEETS),
                findFoodsThatTriggerAnyAllergies(Data.PEOPLE)
        );

        System.out.println("All tests succeeded");
    }
}
