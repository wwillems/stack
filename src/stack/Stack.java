package stack;

/**
 * Created by williamwillems on 06/01/16.
 */
public interface Stack {
    boolean isEmpty();

    int getSize();

    void push(int element);

    int pop();

    int top();

    Integer find(int element);

    public static class IllegalCapacity extends RuntimeException{
    }

    public static class Empty extends RuntimeException{
    }

    public static class Overflow extends RuntimeException {

    }

    public static class Underflow extends RuntimeException {

    }
}
