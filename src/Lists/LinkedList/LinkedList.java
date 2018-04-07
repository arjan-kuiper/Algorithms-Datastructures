package Lists.LinkedList;

import java.util.*;

/*
    The LinkedList class is which is held together via Node objects.
    The first created node will referenced in the LinkedList class's head variable.
    Everytime you perform an modification / access on the LinkedList object it will search through each of the Node
    objects until the correct Node object has been found upon which a modification is required and perform the requested operation.


 */
public class LinkedList<E> implements List<E> {
    private int size;            // keeps track of the number of elements
    private Node head;           // reference to the first node


    //The Node class is used by the LinkedList to make a 'List' with 'Linked' object.
    // Each of the Node objects holds a pointer to the next Node, if there's one. And holds an Object value as 'data'.
    private class Node {
        public E data;
        public Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
        @SuppressWarnings("unused")
        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Constructor of the LinkedList object. Initializes without head  = null; because there isn't anything to point at yet.
    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public boolean add(E element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node node = head;
            // loop until the last Node object has been found
            for (; node.next != null; node = node.next) {}
            //Give the old 'last' Node a reference to a new Node
            node.next = new Node(element);
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        size++;
        if(index == 0)
        {
            // First Node, set as head reference.
            head = new Node(element, head);
        }else{
            //Edit the link of the Node in front to point to the newly created one. Let the new node point to the Node object it replaced.
            getNode(index -1).next = new Node(element, getNode(index));
        }

    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean flag = true;
        for (E element: collection) {
            flag &= add(element);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> collection) { throw new UnsupportedOperationException(); }

    @Override
    public E get(int index) {
        Node node = getNode(index);
        return node.data;
    }

    /** Returns the node at the given index.
     * @param index
     * @return
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public int indexOf(Object target) {
        // Iterate over the nodes by index to check whether it's data Object equals the one's index we're looking for.
        for(int i = 0; i < size; i++)
        {
            if(equals(target, getNode(i).data))
            {
                // First found Object match. Return it's index.
                return i;
            }
        }
        // Not found.
        return -1;
    }

    /** Checks whether an element of the array is the target.
     *
     * Handles the special case that the target is null.
     *
     * @param target
     * @param element
     */
    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        E[] array = (E[]) toArray();
        return Arrays.asList(array).iterator();
    }

    @Override
    public int lastIndexOf(Object target) {
        Node node = head;
        int index = -1;
        for (int i=0; i<size; i++) {
            if (equals(target, node.data)) {
                index = i;
            }
            node = node.next;
        }
        return index;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public E remove(int index) {
        E removeable = get(index);

        if(index == 0)
        {
            head = head.next;
            //Previous head being un-linked from head. Will be removed with the Java Clean-up.
        }else{
            Node prevNode = getNode(index -1);
            // The previous Node Object references the next node, and the next node refers to the node of the node of the deleted Node.
            prevNode.next = prevNode.next.next;
        }
        size--;
        // As a courtesy of kindness one shall be in a state to catch the fallen brother.
        return removeable;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag = true;
        for (Object obj: collection) {
            flag &= remove(obj);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int index, E element) {
        Node node = getNode(index);
        E old = node.data;
        node.data = element;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        LinkedList<E> list = new LinkedList<E>();
        for (Node node=head; node != null; node = node.next) {
            if (i >= fromIndex && i <= toIndex) {
                list.add(node.data);
            }
            i++;
        }
        return list;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node node=head; node != null; node = node.next) {
            // System.out.println(node);
            array[i] = node.data;
            i++;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
}
