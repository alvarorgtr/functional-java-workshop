package examples;

import java.util.function.Consumer;

public class Example1 {
    public static void printInteger(Integer value) {
        System.out.println(value);
    }

    public static void runTwice(Consumer<Integer> consumer, Integer value) {
        consumer.accept(value);
        consumer.accept(value);
    }

    public static void main(String[] args) {
        runTwice(Example1::printInteger, 2);
    }
}
