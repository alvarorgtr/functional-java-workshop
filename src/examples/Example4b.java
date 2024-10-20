package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings({"Convert2MethodRef", "ComparatorCombinators"})
public class Example4b {
    private static void printObjectClassAndImplementedInterfaces(Object o) {
        String className = o.getClass().getName();
        String classInterfaces = Arrays.stream(o.getClass().getInterfaces())
                .map(Class::getName)
                .collect(Collectors.joining(", "));
        System.out.printf("%s (implements %s)\n", className, classInterfaces);
    }

    public static void main(String[] args) {
        Comparator<Integer> comp = (a, b) -> a - b;

        Function<Integer, String> toString = value -> value.toString();

        printObjectClassAndImplementedInterfaces(new ArrayList<String>());
        printObjectClassAndImplementedInterfaces(comp);
        printObjectClassAndImplementedInterfaces(toString);
    }
}
