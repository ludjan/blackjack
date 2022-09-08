package module.src.java.Exceptions;

public class InvalidInputArgumentException extends Exception {
    public InvalidInputArgumentException (String expected, String actual) {
        super(String.format("Expected %s but got %s \n\nCheck your arguments and try again.", expected, actual));
    }
}
