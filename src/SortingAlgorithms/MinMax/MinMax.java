package SortingAlgorithms.MinMax;

public final class MinMax {

    public static int generate(int min, int max){
        return (int)((Math.random() * (max - min)) - ((Math.random() * (max - min)) % 1) + min);
    }
}
