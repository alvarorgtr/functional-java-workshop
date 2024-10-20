package exercises.utils;

import java.util.Objects;

public class Asserts {
    public static <T> void assertEqual(T expected, T actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertException("Elements not equal", expected, actual);
        }
    }
}
