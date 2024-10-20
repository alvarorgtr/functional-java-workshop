package examples;

import java.util.function.Function;
import java.util.function.Supplier;

public class Example6 {
    public static void main(String[] args) {
        Function<Object, String> convert = Object::toString;
        System.out.println(convert.apply(123));

        Supplier<String> newStringSupplier = String::new;
        System.out.println(newStringSupplier.get() == newStringSupplier.get());

        String someString = "abcde";
        Function<Integer, String> substringer = someString::substring;
        System.out.println(substringer.apply(2));
    }
}
