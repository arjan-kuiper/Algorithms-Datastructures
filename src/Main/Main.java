package Main;

import Lists.BinarySearchTree.BinarySearchTree;
import Lists.DoublyLinkedList.DoublyLinkedList;
import Lists.LinkedList.LinkedList;
import Lists.Queue.Queue;
import Lists.Stack.Stack;
import SortingAlgorithms.QuickSort.QuickSort;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

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
        populateLists();
    }

    public static void main(String[] args)
    {
        Main main = new Main();
    }

    // Method to easily populate all the created collections.
    private void populateLists()
    {

    }

    private Item getItemById(int id)
    {
        for(Item item : items){
            if(item.getItemNr() == id){
                return item;
            }
        }
        return null;
    }

}
