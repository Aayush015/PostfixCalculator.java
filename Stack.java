/** Generic interface describing a stack. */
public interface Stack<T> {
    /** Is the stack empty? */
    boolean isEmpty();

    /** Push item onto top of stack. */
    void push(T val);

    /** Pop the item from the top of the stack and return it. */
    T pop();

    /** Return the top item on the stack without removing it. */
    T peek();
}