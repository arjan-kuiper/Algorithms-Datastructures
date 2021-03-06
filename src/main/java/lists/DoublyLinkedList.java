package lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DoublyLinkedList<E> implements List<E> {
    private Node head;
    private Node tail;
    private int size = 0;


    // The Node class is used by the LinkedList to make a 'List' with 'Linked' object.
    // Each of the Node objects holds a pointer to the next Node, if there's one. And holds an Object value as 'data'.
    private class Node {
        public E data;
        public Node next;
        public Node prev;

        public Node(E data, Node prev) {
            this.data = data;
            this.next = null;
            this.prev = prev;
        }

        @SuppressWarnings("unused")
        public Node(E data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean add(E element) {
        if (head == null) {
            head = new Node(element, null);
            tail = head;
        } else {
            Node node = head;
            // loop until the last node
            for (; node.next != null; node = node.next) {
            }
            node.next = new Node(element, null, node);
            tail = node.next;
        }

        size++;
        return true;
    }

    public void add(int index, E element) {
        if (index == 0) {
            head = new Node(element, head);
        } else {
            Node prevNode = getNode(index).prev;
            Node cNode = getNode(index);

            Node nNode = new Node(element, cNode, prevNode);
            prevNode.next = nNode;
            cNode.prev = nNode;
        }
        size++;
    }

    public E remove(int index) {
        E removeable = get(index);
        System.out.println();
        if (index == 0) {
            head = head.next;
            //Previous head being un-linked from head. Will be removed with the Java Clean-up.
        } else if (size - 1 == index) {
            System.out.println("Echo");
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            Node prevNode = getNode(index - 1);
            Node nextNode = getNode(index + 1);
            // The previous Node Object references the next node, and the next node refers to the node of the node of the deleted Node.
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
        return removeable;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        boolean flag = true;
        for (E element : collection) {
            flag &= add(element);
        }
        return flag;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public E get(int index) {
        Node node = getNode(index);
        return node.data;
    }

    private Node getNode(int index) {
        // Check range
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // If it is closer to the left range, begin from the head and work towards tail until node has been found.
        if (size / 2 > index) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
            // If it is closer to the right range, begin from tail and work in direction head until node has been found..
        } else {
            Node node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public int indexOf(Object target) {
        for (int i = 0; i < size; i++) {
            if (equals(target, getNode(i).data)) {
                return i;
            }
        }
        return -1;
    }

    // Checks whether a certain
    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
