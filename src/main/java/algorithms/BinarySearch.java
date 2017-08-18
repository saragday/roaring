package algorithms;

public class BinarySearch {

    private static int binarySearch(int low, int high, int key, int[] array) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (array[mid] == key) {
            return mid;
        } else if (array[mid] < key) {
            return binarySearch(mid + 1, high, key, array);
        } else {
            return binarySearch(low, mid - 1, key, array);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(binarySearch(0, 11, 12, array));
    }

}
