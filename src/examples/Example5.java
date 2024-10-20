package examples;

public class Example5 {
    @FunctionalInterface
    public interface TernaryOperator<T> {
        T apply(T arg1, T arg2, T arg3);
    }

    public static void main(String[] args) {
        TernaryOperator<Integer> operator = (a, b, c) -> (a + b) * c;
        System.out.println(operator.apply(3, 2, 7));  // Prints "35"
    }
}
