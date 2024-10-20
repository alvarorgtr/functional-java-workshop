package exercises.utils;

public class AssertException extends RuntimeException {
    public AssertException(String message, Object expected, Object actual) {
        super(String.format("%s: Expected %s, but got %s", message, expected, actual));
    }
}
