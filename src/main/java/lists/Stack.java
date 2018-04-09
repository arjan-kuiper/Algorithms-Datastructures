package lists;

import java.util.EmptyStackException;

public class Stack<E> {
    private StackNode top;

    //  Each StackNode object holds a link to the previous node, so it can traverse the stack from top to bottom. It also contains a variable for the data to be stored.
    private class StackNode {
        public StackNode prevNode;
        public E data;

        // In case it is the first item on the stack, it will not have previous nodes. Thus a prevNode reference is not required.
        public StackNode(E data) {
            this.data = data;
            this.prevNode = null;
        }

        // Same as the above, except here you can enter what object of StackNode it should link back to.
        public StackNode(E data, StackNode prev) {
            this.data = data;
            this.prevNode = prev;
        }
    }

    public Stack() {
        // Initialize the starting values.
        top = null;
    }

    // add a new object to the StackNode chain.
    public E push(E item) {
        if (top == null)
            top = new StackNode(item);
        else {
            StackNode newNode = new StackNode(item, top);
            top = newNode;
        }
        return item;
    }

    // Removes the first item on the stack, and returns it. If none, shows EmptyStackException.
    public E pop() {
        E data = peek();
        top = top.prevNode;
        return data;
    }

    // Returns the top of the stack. If no top, shows EmptyStackException.
    public E peek() {
        if (empty())
            throw new EmptyStackException();
        else

            return top.data;
    }

    // Checks whether there is atleast one object in the stack.
    // This is determined by checking whether the top has been set to a StackNode object.
    public boolean empty() {
        return top == null;
    }

    // Returns how many items are on the stack above the object you're looking for.
    public int search(Object obj) {
        StackNode cNode = top;
        int count = 0;


        // Check whether you found the object reference, also checks if you haven't hit the bottom of the stack.
        while (cNode.prevNode != null || cNode.data == obj) {
            if (cNode.data == obj) {
                return count;
            }
            cNode = cNode.prevNode;
            count++;
        }
        return -1;
    }
}
