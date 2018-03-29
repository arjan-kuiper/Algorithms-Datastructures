package SortingAlgorithms.BinarySearch;

public final class BinarySearch {

    public static int search(int sortedArray[], int key){
        int low = 0;
        int high = sortedArray.length;

        while(low <= high){
            int middle = low + (high - low) / 2;
            if(key < sortedArray[middle]){
                high = middle--;
            }else if(key > sortedArray[middle]){
                low = middle++;
            }else return middle;
        }
        return -1;
    }

}
