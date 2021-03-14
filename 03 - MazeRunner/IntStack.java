public class IntStack implements BoundedStackInterface {
    // field variables
    public static final int DEFCAP = 100;
    private int[] stack;
    private int topIndex;   
    
    // methods
    // constructors
    public IntStack() {
        stack = new int[DEFCAP];
        topIndex = -1;
    }
    
    public IntStack(int max) {
        stack = new int[max];
        topIndex = -1;
    }
    
    // observers
    public boolean isEmpty() {
        return (topIndex == -1);
    }
    
    public boolean isFull() {
        if (topIndex == stack.length -1)
            return true;
        else
            return false;
    }
    
    public int top() throws StackUnderflowException {
        if (!isEmpty())
            return stack[topIndex];
        else
            throw new StackUnderflowException("Top attempted on empty stack");
    }
    
    // transformers
    
    public void pop() throws StackUnderflowException {
        if (!isEmpty())
            topIndex--;
        else
            throw new StackUnderflowException("Pop attempted on empty stack");
    }
    
    public void push(int item) throws StackOverflowException  {
        if (!isFull()) {
            topIndex++;
            stack[topIndex] = item;
        } else
            throw new StackOverflowException("Push attempted on full stack");
    }
}    