package exercises;

import exercises.utils.Asserts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
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
        return new Collector<T, List<T>, List<T>>() {
            @Override
            public Supplier<List<T>> supplier() {
                return ArrayList::new;
            }

            @Override
            public BiConsumer<List<T>, T> accumulator() {
                return List::add;
            }

            @Override
            public BinaryOperator<List<T>> combiner() {
                return (l1, l2) -> {
                    List<T> result = new ArrayList<>();
                    result.addAll(l1);
                    result.addAll(l2);
                    return result;
                };
            }

            @Override
            public Function<List<T>, List<T>> finisher() {
                return Function.identity();
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Set.of(Characteristics.IDENTITY_FINISH);
            }
        };
    }

    private static class MeanAccumulator {
        double current;
        int size;

        public MeanAccumulator(double current, int size) {
            this.current = current;
            this.size = size;
        }
    }

    /**
     * Build a collector that computes the <a href="https://en.wikipedia.org/wiki/Geometric_mean">geometric mean</a>.
     *
     * @return an instance of the collector.
     * @param <N> the contents of the stream, which must be numbers.
     */
    private static <N extends Number> Collector<N, ?, Double> geometricMeanCollector() {
        return new Collector<N, MeanAccumulator, Double>() {
            @Override
            public Supplier<MeanAccumulator> supplier() {
                return () -> new MeanAccumulator(1d, 0);
            }

            @Override
            public BiConsumer<MeanAccumulator, N> accumulator() {
                return (a, n) -> {
                    a.size += 1;
                    a.current *= n.doubleValue();
                };
            }

            @Override
            public BinaryOperator<MeanAccumulator> combiner() {
                return (a1, a2) -> new MeanAccumulator(a1.current * a2.current, a1.size + a2.size);
            }

            @Override
            public Function<MeanAccumulator, Double> finisher() {
                // Take the size-th root
                return a -> Math.pow(a.current, 1d / a.size);
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Set.of(Characteristics.UNORDERED);
            }
        };
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

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Podium<?>)) {
                return false;
            }
            Podium<?> other = (Podium<?>) o;
            return Objects.equals(first, other.first)
                    && Objects.equals(second, other.second)
                    && Objects.equals(third, other.third);
        }
    }

    /**
     * Build a collector that builds a Podium<T> with the three best types.
     * @return an instance of the collector.
     * @param <T> the contents of the stream.
     */
    private static <T extends Comparable<T>> Collector<T, ?, Podium<T>> podiumCollector() {
        return new Collector<T, Podium<T>, Podium<T>>() {
            @Override
            public Supplier<Podium<T>> supplier() {
                return Podium::new;
            }

            private void addToPodium(Podium<T> p, T e) {
                if (e != null) {
                    if (p.first == null || e.compareTo(p.first) > 0) {
                        p.third = p.second;
                        p.second = p.first;
                        p.first = e;
                    } else if (p.second == null || e.compareTo(p.second) > 0) {
                        p.third = p.second;
                        p.second = e;
                    } else if (p.third == null || e.compareTo(p.third) > 0) {
                        p.third = e;
                    }
                }
            }

            @Override
            public BiConsumer<Podium<T>, T> accumulator() {
                return this::addToPodium;
            }

            @Override
            public BinaryOperator<Podium<T>> combiner() {
                return (p1, p2) -> {
                    Podium<T> p = new Podium<>();
                    for (Podium<T> otherPodium: List.of(p1, p2)) {
                        addToPodium(p, otherPodium.first);
                        addToPodium(p, otherPodium.second);
                        addToPodium(p, otherPodium.third);
                    }
                    return p;
                };
            }

            @Override
            public Function<Podium<T>, Podium<T>> finisher() {
                return Function.identity();
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Set.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED);
            }
        };
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
