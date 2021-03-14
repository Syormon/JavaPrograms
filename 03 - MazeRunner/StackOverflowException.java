// taken from the book on page 170
public class StackOverflowException extends RuntimeException {
    public StackOverflowException() {
      super();
    }

    public StackOverflowException(String message) {
      super(message);
    }
}