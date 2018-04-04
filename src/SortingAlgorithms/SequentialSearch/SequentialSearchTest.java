package SortingAlgorithms.SequentialSearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequentialSearchTest {

    @Test
    public void sort() throws Exception {
        int[] searchable = new int[]{1, 4, 5, 8, 10, 15, 75, 190};
        int key = 8;
        int expectedIndex = 3;

        assertEquals(expectedIndex, SequentialSearch.search(searchable, key));
    }
}