package SortingAlgorithms.BubbleSort;


public class BubbleSort {

    /* Sorteren van de nummers met bubbleSort */
    void sortingNumbers(int arrayNumbers[])
    {
        int length = arrayNumbers.length;                       // Lengte van de array
        for (int i = 0; i < length-1; i++)                      // Loop die doorgaat totdat de lengte van de array bereikt is
        {
            for (int j = 0; j < length - i - 1; j++)            // Loop die doorgaat totdat de lengte van de array bereikt is
            {
                if (arrayNumbers[j] > arrayNumbers[j + 1])      //
                {
                    int temp = arrayNumbers[j];                 // Nieuwe variabele die de het nummer op locatie j in arrayNumbers bevat
                    arrayNumbers[j] = arrayNumbers[j + 1];      // Locatie j in arrayNumbers wordt overschreven met het nummer na locatie j
                    arrayNumbers[j + 1] = temp;                 // Nummer op nieuwe locatie wordt oude nummer op locatie j, deze stond in de nieuw aangemaakte variabele
                }
            }
        }
    }

    /* Printen van de array */
    void printArray(int arrayNumbers[])
    {
        int length = arrayNumbers.length;               // Lengte van de array
        for (int i=0; i<length; ++i)                    // Bepalen d.m.v. loop hoe vaak er een number geprint moet worden
        {
            System.out.print(arrayNumbers[i] + " ");    // Printen van de nummers in de array op zelfde regel
        }
        System.out.println();                           // Nieuwe regel
    }

    /* Aanmaken van de array en bubbleSort */
    public static void main(String args[])
    {
        BubbleSort bubbleSort = new BubbleSort();                                        // Nieuwe bubbelSort aanmaken
        int arrayNumbers[] = {1,18,7,4,14,6,10,11,9,8,110,142,-4,-8,35,16,17,2,19,20};   // Array met alle nummers
        bubbleSort.sortingNumbers(arrayNumbers);                                         // Methode sortingNumbers gebruiken voor het sorteren van de nummers
        System.out.println("Gesorteerd");                                                // Printen van info
        bubbleSort.printArray(arrayNumbers);                                             // Printen van de nieuwe array, d.m.v. de methode printArray
    }
}
