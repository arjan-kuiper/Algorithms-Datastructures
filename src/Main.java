import Lists.BinarySearchTree.BinarySearchTree;
import Lists.DoublyLinkedList.DoublyLinkedList;
import Lists.LinkedList.LinkedList;
import Lists.Queue.Queue;
import Lists.Stack.Stack;

import java.util.ArrayList;

public class Main {
    private ArrayList<Item> items = new ArrayList<>();
    private BinarySearchTree bst;
    private DoublyLinkedList dll;
    private LinkedList ll;
    private Queue q;
    private Stack s;

    public Main() {
        items = JSONHandler.getItemsArrayList();
    }


    public static void main(String[] args)
    {
        Main main = new Main();
    }

}
