package exercises;

import java.util.List;
import java.util.stream.Collector;

public class Exercise7YourOwnCollectors {
    /**
     * Build a collector mimicking Collectors.toList()
     * @return an instance of the collector.
     * @param <T> the contents of the stream.
     */
    private static <T> Collector<T, ?, List<T>> customToListCollector() {
        // FIXME: should return a custom collector class that acts the same as Collectors.toList()
        return null;
    }

    private static class Podium<T extends Comparable<T>> {
        private final T first;
        private final T second;
        private final T third;

        public Podium() {
            this.first = null;
            this.second = null;
            this.third = null;
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
        return null;
    }

    public static void main(String[] args) {

    }
}
