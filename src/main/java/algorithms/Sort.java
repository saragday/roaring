package algorithms;

import java.util.Arrays;

public class Sort {

    private static void insertionSort(int[] toSort) {
        for (int i = 1; i < toSort.length; i++) {
            int index = -1;
            for (int j = 0; j < i; j++) {
                if (toSort[i] < toSort[j]) {
                    index = j;
                    break;
                }
            }
            if (index >= 0) {
                int val = toSort[i];
                System.arraycopy(toSort, index, toSort, index + 1, i - index);
                toSort[index] = val;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] { 7, 8, 9, 6, 5, 4, 32, 1 };
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

}
