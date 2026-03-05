package opgave01.models;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListStack<E> implements StackEaaa<E>{

    private ArrayList<E> stack = new ArrayList<>();

    @Override
    public void push(E element) {
        stack.add(element);
    }

    @Override
    public E pop() {
        if (stack.isEmpty()) throw new NoSuchElementException("Stack is empty");
        return stack.removeLast();
    }

    @Override
    public E peek() {
        if (stack.isEmpty()) throw new NoSuchElementException("Stack is empty");
        return stack.getLast();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
