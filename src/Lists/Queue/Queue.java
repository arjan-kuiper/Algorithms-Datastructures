package Lists.Queue;

import java.util.*;

public class Queue<T> implements Iterable<T>{

    private LinkedList<T> elements = new LinkedList<T>();

    public static void main(String[] args) {

    }

    public void enqueue(T element) {
        elements.add(element);
    }

    public T dequeue() {
        if (isEmpty()) { // Throwing IllegalStateException if it is empty.
            return null;
        }
        // Returns null if it is empty.
        return elements.remove(0);
    }

    public T peek() {
        if (isEmpty()) { // Returns null if it is empty.
            return null;
        }
        // Returns the first object of the LinkedList.
        return elements.get(0); // Get(0), so the first element returns
    }

    public void clear() {
        // Clears the LinkedList
        elements.clear();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Returns the object at the head of the Stack without removing it.
    public T element() {
        if (isEmpty()) { // Throwing IllegalStateException if is empty.
            throw new IllegalStateException();
        }

        // Returns the first object of the LinkedList.
        return elements.get(0); // Get(0), so the first element returns
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}