package learnone.java.algorithm.sorting;

import java.util.Arrays;

public class QuickSort implements Sortable {

    int counts = 0;

    @Override
    public boolean sort(int[] array) {
        if (array == null)
            return false;
        if (array.length == 0)
            return true;

        quickSort(array, 0, array.length - 1);
        System.out.println(counts);
        return true;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotOffset = takePart(array, low, high);
            quickSort(array, low, pivotOffset - 1);
            quickSort(array, pivotOffset + 1, high);
        }
    }

    private int takePart(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            counts++;
            if (low < high && array[high] >= pivot) {
                high--;
            }
            if (low < high) {
                array[low] = array[high];
            }
            if (low < high && array[low] <= pivot) {
                low++;
            }
            if (low < high) {
                array[high] = array[low];
            }
        }
        array[low] = pivot;
        return low;
    }

    public static void main(String[] args) {

        Sortable sorter = new QuickSort();

//        int[] disordered = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
//        int[] disordered = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3 };
        int[] disordered = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3 };
//        int[] disordered = { 9 };
//        int[] disordered = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//        int[] disordered = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        sorter.sort(disordered);
        System.out.println(Arrays.toString(disordered));
    }

}
