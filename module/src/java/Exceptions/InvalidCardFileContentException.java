package module.src.java.Exceptions;

public class InvalidCardFileContentException extends Exception {

    public InvalidCardFileContentException(String subject, Object expected, Object actual, int position) {
        super(String.format("Expected %s to be %s, but found %s on position %d\n\nCheck your file and try again.", subject, expected, actual, position+1));
    }
    
}
