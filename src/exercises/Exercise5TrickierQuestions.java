package exercises;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Exercise5TrickierQuestions {
    /**
     * The questions in this section are significantly more complicated. There is no guarantee there will be an
     * "easy" solution. Attempt at your own risk!
     */

    private static class Bin {
        private final int start; // Inclusive
        private final int end;   // Exclusive

        public Bin(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    /**
     * Builds a histogram with the given bins.
     * @param values the values for each item, to check the bin it belongs to.
     * @param bins the list of bins to fill.
     * @return a map associating each bin with the items it contains.
     * @param <T> the type of items we are histogramming.
     */
    private <T> Map<Bin, List<T>> buildHistogram(Map<T, Integer> values, List<Bin> bins) {
        // FIXME: implement using streams
        return Collections.emptyMap();
    }

    /**
     * Builds a histogram creating bins with the given start, step and end.
     * If start = 1, step = 3, end = 7; the bins will be [1,4), [4,7)
     * @param values the values for each item, to check the bin it belongs to.
     * @param start the start of the first bin, inclusive.
     * @param end the end of the last bin, exclusive. Guaranteed to be congruent with start modulo step.
     * @param step the size of each bin.
     * @return a map associating each bin with the items it contains.
     * @param <T> the type of items we are histogramming.
     */
    private <T> Map<Bin, List<T>> buildHistogram(Map<T, Integer> values, int start, int end, int step) {
        // FIXME: implement using streams
        // Extra: do it in a single line (i.e. with a single semicolon, please don't do a real single line!)
        return Collections.emptyMap();
    }

    /**
     * Compute the factorial n! of n, modulo mod.
     * n! = n * (n-1) * (n-2) * ...
     * @param n the value.
     * @param mod the modulus to take.
     * @return the factorial modulo mod.
     */
    private long factorial(long n, long mod) {
        // FIXME: implement using streams
        return 0;
    }

    /**
     * Compute the double factorial n!! of n.
     * n!! = n * (n-2) * (n-4) * ...
     * @param n the value
     * @return the double factorial.
     */
    private long doubleFactorial(long n) {
        // FIXME: implement using streams
        // You can assume that the return value fits into a long
        return 0;
    }

    /**
     * Compute a list of bins from the given list of integers.
     * E.g. [1, 2, 3, 4] => [Bin(1,2), Bin(3,4)]
     * @param values the values to pair.
     */
    private List<Bin> pairBins(List<Integer> values) {
        // FIXME: implement using streams
        return Collections.emptyList();
    }

    /**
     * Returns a list of size amount with the numbers n^0 - 1, n^1 - 1, n^2 - 1 etc.
     * @param n the base.
     * @param amount the number of items in the list.
     * @return the list.
     */
    private List<Integer> powersOfNMinus1(int n, int amount) {
        // FIXME: implement using streams and without using exponents
        return Collections.emptyList();
    }

    public static void main(String[] args) {

    }
}
