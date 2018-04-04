package SortingAlgorithms.BubbleSort;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void sort() throws Exception {
        int[] searchable = new int[]{1, 5, 190, 52, 10, 15, 2, 270};
        int[] expected = new int[]{1, 2, 5, 10, 15, 52, 190, 270};

        searchable = BubbleSort.sort(searchable);

        assertArrayEquals(expected, searchable);
    }
}