package SortingAlgorithms.SequentialSearch;

public final class SequentialSearch {

    public static int search(int[] input, int key) {
        for (int j = 0; j < input.length; j++) {
            if (input[j] == key) {
                return j;
            }
        }
        return -1;
    }
}
