import Lists.BinarySearchTree.BinarySearchTree;
import Lists.DoublyLinkedList.DoublyLinkedList;
import Lists.LinkedList.LinkedList;
import Lists.Queue.Queue;
import Lists.Stack.Stack;
import SortingAlgorithms.BinarySearch.BinarySearchTest;
import SortingAlgorithms.BubbleSort.BubbleSortTest;
import SortingAlgorithms.MinMax.MinMax;
import SortingAlgorithms.QuickSort.QuickSort;
import SortingAlgorithms.QuickSort.QuickSortTest;
import SortingAlgorithms.SequentialSearch.SequentialSearch;
import junit.framework.Test;
import junit.framework.TestResult;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;

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
        int[] ids = new int[items.size()];
        for(int i = 0; i < ids.length; i++){
            ids[i] = items.get(i).getItemNr();
        }
        System.out.println("All LEGO items were added to an ids array");

        for(int i = 0; i < ids.length; i++){
            System.out.print(ids[i] + " ");
        }
        System.out.println("");
        ids = QuickSort.sort(ids, 0, ids.length - 1);

        for(int i = 0; i < ids.length; i++){
            System.out.print(ids[i] + " ");
        }
        System.out.println("");

        // TODO - Test below here
        JUnitCore junitCore = new JUnitCore();
        junitCore.addListener(new TextListener(System.out));
        //junitCore.run(<someclass>.class);
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
