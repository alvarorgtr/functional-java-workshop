package exercises;

import exercises.utils.Asserts;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1WarmUp {
    /**
     * Returns a list of all numbers strictly greater than value.
     * @param numbers the input numbers.
     * @param value the value to compare against.
     * @return the list of numbers meeting the condition.
     */
    private static List<Integer> numbersGreaterThan(List<Integer> numbers, int value) {
        return numbers.stream()
                .filter(n -> n > value)
                .collect(Collectors.toList());
    }

    /**
     * Returns a list of all numbers converted to strings (3 => "3").
     * @param numbers the input numbers.
     * @return the list of numbers as strings.
     */
    private static List<String> numbersAsString(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)  // You could also use i -> i.toString()
                .collect(Collectors.toList());
    }

    /**
     * Returns a list of lists, where each number appears as many times as its value.
     * E.g. [3, 2, 0] => [[3, 3, 3], [2, 2], []]
     * @param numbers the input numbers.
     * @return the list of numbers as strings.
     */
    private static List<List<Integer>> numbersRepeated(List<Integer> numbers) {
        return numbers.stream()
                .map(i -> Collections.nCopies(i, i))
                .collect(Collectors.toList());
    }

    /**
     * Returns the product of all numbers in the list. If the list is empty, it should return 1.
     * @param numbers the input numbers.
     * @return the product of all numbers in the array.
     */
    private static Integer product(List<Integer> numbers) {
        return numbers.stream()
                .reduce(1, (a, i) -> a * i);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 4, 8, 6, 8, 3, 7, 1, 9, 3, 3, 4);

        Asserts.assertEqual(List.of(8, 6, 8, 7, 9), numbersGreaterThan(numbers, 5));
        Asserts.assertEqual(numbers, numbersGreaterThan(numbers, 0));

        Asserts.assertEqual(List.of("1", "4", "8", "6", "8", "3", "7", "1", "9", "3", "3", "4"),
                numbersAsString(numbers));

        Asserts.assertEqual(List.of(List.of(2, 2), List.of(), List.of(3, 3, 3), List.of(1)),
                numbersRepeated(List.of(2, 0, 3, 1)));

        Asserts.assertEqual(10450944, product(numbers));
        Asserts.assertEqual(1, product(Collections.emptyList()));

        System.out.println("All tests succeeded");
    }
}
