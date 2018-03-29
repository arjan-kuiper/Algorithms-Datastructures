package SortingAlgorithms.InsertionSort;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {
    @Test
    public void sort() throws Exception {
        int toSort[] = new int[]{6, 2, 3, 9, 5};
        int expected[] = new int[]{2, 3, 5, 6, 9};

        toSort = InsertionSort.sort(toSort);
        assertArrayEquals(expected, toSort);
    }

}