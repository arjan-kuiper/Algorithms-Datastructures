package SortingAlgorithms.BinarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void search() throws Exception {
        int[] searchable = new int[]{1, 4, 5, 8, 10, 15, 75, 190};
        int key = 190;
        int expectedIndex = 2;

        assertEquals(expectedIndex, BinarySearch.search(searchable, key));
    }

}