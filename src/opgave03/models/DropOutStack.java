package opgave03.models;

import opgave01.models.StackEaaa;

import java.util.NoSuchElementException;

public class DropOutStack<E> implements StackEaaa<E> {

    private int maxSize;
    private int size;
    private Node<E> top;
    private Node<E> buttom;

    public DropOutStack(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.top = null;
        this.buttom = null;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);

        if (size == 0) top = buttom = newNode;
        else {
            newNode.previous = top;
            top.next = newNode;
            top = newNode;
        }
        size++;

        if (size > maxSize) {
            buttom = buttom.next;
            buttom.previous = null;
            size--;
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");

        E element = top.element;

        if (size == 1) {
            clear();
            return element;
        } else {
            top = top.previous;
            top.next = null;
        }
        size--;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");

        return top.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        top = buttom = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node<T> {
        T element;
        Node<T> next;
        Node<T> previous;

        public Node(T element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }
    }
}
