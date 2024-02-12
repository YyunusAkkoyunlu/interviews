package preperation.crackingTheCodingInterview;

public class FullStackException extends Exception {
    public FullStackException() {
        super("Stack is full");
    }

    public FullStackException(String message) {
        super(message);
    }

}
