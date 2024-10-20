package examples;

public class Example2 {
    static int counter = 0;

    public static int incrementValue(int value) {
        return value + 1;
    }

    public static void incrementCounter() {
        counter += 1;   // NOT PURE! Side effect
    }

    public static void main(String[] args) {
        counter = incrementValue(counter);

        incrementCounter();
    }
}
