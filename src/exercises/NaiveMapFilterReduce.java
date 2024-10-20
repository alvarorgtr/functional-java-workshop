package exercises;

import exercises.utils.Asserts;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class NaiveMapFilterReduce {
    private static <T, R> List<R> map(List<T> list, Function<T, R> transform) {
        // TODO: Implement

        // Returns a list with all elements of "list" after applying the function "transform" to each
        return Collections.emptyList();
    }

    private static <T, R> List<R> filter(List<T> list, Predicate<T> filterPredicate) {
        // TODO: Implement

        // Returns a list with the elements of "list" for which "filterPredicate" returns true
        return Collections.emptyList();
    }

    private static <T, A> A reduce(List<T> list, BiFunction<A, T, A> accumulate, A startingElement) {
        // TODO: Implement

        // Returns a single accumulator of type A. The value of the accumulator starts at "startingElement". For each
        // element of "list", we apply "accumulate" to the current accumulator and the element of the list, storing
        // the value back into the accumulator.
        return null;
    }

    public static void main(String[] args) {
        List<String> strings = List.of("abc", "abcd", "abcde", "def", "defg", "defgh");
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> mapped = map(strings, String::length);
        Asserts.assertEqual(List.of(3, 4, 5, 3, 4, 5), mapped);

        List<Integer> filtered = filter(strings, s -> s.length() > 4);
        Asserts.assertEqual(List.of("abcde", "defgh"), filtered);

        Integer reduced = reduce(integers, Integer::sum, 5);
        Asserts.assertEqual(60, reduced);
    }
}
