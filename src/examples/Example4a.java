package examples;

import java.util.Comparator;
import java.util.function.Function;

@SuppressWarnings("Convert2MethodRef")
public class Example4a {
    public static void main(String[] args) {
        // DOES NOT COMPILE
        //Object c = (Integer a) -> a + 1;

        Comparator<Integer> comp = (a, b) -> a - b;

        Function<Integer, String> toString = value -> value.toString();
    }
}
