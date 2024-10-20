package examples;

import exercises.utils.Asserts;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings({"SimplifyStreamApiCallChains", "Convert2MethodRef"})
public class Example7 {
    public static void main(String[] args) {
        List<String> strings = List.of("abc", "abcd", "abcde", "def", "defg", "defgh");
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> mapped = strings.stream()
                .map(String::length)
                .collect(Collectors.toList());

        List<String> filtered = strings.stream()
                .filter(s -> s.length() > 4)
                .collect(Collectors.toList());

        Integer reduced = integers.stream()
                .reduce(5, (a, b) -> a + b);
    }
}
