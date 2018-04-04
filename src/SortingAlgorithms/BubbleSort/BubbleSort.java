package SortingAlgorithms.BubbleSort;

public final class BubbleSort {

    public static int[] sort(int[] input){
        int length = input.length;                          // Lengte van de array
        for (int i = 0; i < length-1; i++)                  // Loop die doorgaat totdat de lengte van de array bereikt is
        {
            for (int j = 0; j < length - i - 1; j++)        // Loop die doorgaat totdat de lengte van de array bereikt is
            {
                if (input[j] > input[j + 1])
                {
                    int temp = input[j];                    // Nieuwe variabele die de het nummer op locatie j in arrayNumbers bevat
                    input[j] = input[j + 1];                // Locatie j in arrayNumbers wordt overschreven met het nummer na locatie j
                    input[j + 1] = temp;                    // Nummer op nieuwe locatie wordt oude nummer op locatie j, deze stond in de nieuw aangemaakte variabele
                }
            }
        }
        return input;
    }
}
