// taken from the book on page 170

public class StackUnderflowException extends RuntimeException {
    public StackUnderflowException() {
        super();
    }

    public StackUnderflowException(String message) {
        super(message);
    }
}