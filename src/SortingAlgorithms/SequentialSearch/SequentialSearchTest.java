package SortingAlgorithms.SequentialSearch;

import Main.Item;
import Main.JSONHandler;
import SortingAlgorithms.BubbleSort.BubbleSort;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SequentialSearchTest {

    private ArrayList<Item> items = new ArrayList<>();
    private int[] ids;

    @Before
    public void initialize()
    {
        items = JSONHandler.getItemsArrayList();
        ids = new int[items.size()];
        for(int i = 0; i < ids.length; i++){
            ids[i] = items.get(i).getItemNr();
        }
        System.out.println("All LEGO items were added to an ids array");
    }

    @Test
    public void sort() throws Exception {
        int key = 2063;

        assertEquals(2, SequentialSearch.search(BubbleSort.sort(ids), key));
    }
}