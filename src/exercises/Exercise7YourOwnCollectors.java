package exercises;

import exercises.utils.Asserts;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise7YourOwnCollectors {
    /**
     * Build a collector mimicking Collectors.toList()
     * @return an instance of the collector.
     * @param <T> the contents of the stream.
     */
    private static <T> Collector<T, ?, List<T>> customToListCollector() {
        // FIXME: should return a custom collector class that acts the same as Collectors.toList()
        // Tip: you can choose to use Collectors.of() instead of building a class, depending on your preference
        return null;
    }

    /**
     * Build a collector that computes the <a href="https://en.wikipedia.org/wiki/Geometric_mean">geometric mean</a>.
     *
     * @return an instance of the collector.
     * @param <N> the contents of the stream, which must be numbers.
     */
    private static <N extends Number> Collector<N, ?, Double> geometricMeanCollector() {
        // FIXME: should return a custom collector class that calculates the geometric mean
        // Wikipedia: https://en.wikipedia.org/wiki/Geometric_mean
        // Tip: you can choose to use Collectors.of() instead of building a class, depending on your preference
        // Extra: can you build another collector using the second formula in the wikipedia article?
        return null;
    }

    private static class Podium<T extends Comparable<T>> {
        private T first;
        private T second;
        private T third;

        public Podium(T first, T second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public Podium() {
            this(null, null, null);
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }

        public T getThird() {
            return third;
        }
    }

    /**
     * Build a collector that builds a Podium<T> with the three best types.
     * @return an instance of the collector.
     * @param <T> the contents of the stream.
     */
    private static <T extends Comparable<T>> Collector<T, ?, Podium<T>> podiumCollector() {
        // FIXME: should return a custom collector class that builds a podium
        // Tip: you can choose to use Collectors.of() instead of building a class, depending on your preference
        return null;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 6, 1, 9, 2, 3, 7);

        // Test custom list collector
        Asserts.assertEqual(
                numbers,
                numbers.stream().collect(customToListCollector())
        );

        // Test geometric mean collector
        Asserts.assertApproxEqual(
                1d,
                Collections.nCopies(50, 1).stream().collect(geometricMeanCollector())
        );
        Asserts.assertApproxEqual(
                5d,
                Collections.nCopies(50, 5).stream().collect(geometricMeanCollector())
        );
        Asserts.assertApproxEqual(
                5d,
                Collections.nCopies(50, 5).parallelStream().collect(geometricMeanCollector())
        );
        Asserts.assertApproxEqual(
                0.5d,
                Stream.of(4d, 1d, 1d / 32).collect(geometricMeanCollector())
        );
        Asserts.assertApproxEqual(
                0.5d,
                List.of(4d, 1d, 1d / 32).parallelStream().collect(geometricMeanCollector())
        );

        // Test podium collector
        Asserts.assertEqual(
                new Podium<>(99, 98, 97),
                IntStream.range(1, 100).boxed().collect(podiumCollector())
        );
        Asserts.assertEqual(
                new Podium<>(9, 8, 7),
                Stream.of(1, 3, 5, 6, 1, 2, 3, 5, 8, 6, 0, 9, 7, 2).collect(podiumCollector())
        );
        Asserts.assertEqual(
                new Podium<>(9, 8, 7),
                List.of(1, 3, 5, 6, 1, 2, 3, 5, 8, 6, 0, 9, 7, 2).parallelStream().collect(podiumCollector())
        );

        System.out.println("All tests passed");
    }
}
