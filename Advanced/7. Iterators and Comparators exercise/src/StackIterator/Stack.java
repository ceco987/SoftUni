package StackIterator;

public class Stack<E> {
    private Node<E> top;

    private static class Node<E> {
        E element;
        Node<E> prev;

        Node(E element) {
            this.element = element;
        }
    }

    public Stack() {
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.prev = this.top;
        this.top = newNode;
    }

    public E pop() {
        if (this.top == null) {
            return null;
        }
        E element = this.top.element;
        Node<E> prev = this.top.prev;
        this.top.prev = null;
        this.top = prev;
        return element;
    }
}
