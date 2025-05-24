package hust.soict.hedspi.aims.exception;

public class PlayerException extends Exception {

    // Constructor with no arguments
    public PlayerException() {
        super();
    }

    // Constructor with custom message
    public PlayerException(String message) {
        super(message);
    }
}