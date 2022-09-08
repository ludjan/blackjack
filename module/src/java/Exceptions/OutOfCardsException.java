package module.src.java.Exceptions;

public class OutOfCardsException extends Exception {
    public OutOfCardsException (int pulledCards){
        super(String.format("Tried to pull card number %d but deck was empty", pulledCards));
    }
}
