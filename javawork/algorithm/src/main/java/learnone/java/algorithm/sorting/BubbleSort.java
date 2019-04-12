package learnone.java.algorithm.sorting;

import java.util.Arrays;

public class BubbleSort implements Sortable {

    int compare(int first, int second) {
        if (first == second) {
            return 0;
        } else {
            return (first < second) ? -1 : 1;
        }
    }

    @Override
    public boolean sort(int[] a) {
        if (a == null)
            return false;
        if (a.length == 0)
            return true;

        boolean sequential = false;
        int counts = 0;
        int temp;
        for (int i = 0; i < a.length; i++) {
            sequential = true;
            for (int j = 0; j < a.length - i - 1; j++) {
                counts++;
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    sequential = false;
                }
            }
            if (sequential) {
                break;
            }
        }
        System.out.println(counts);
        return true;
    }

    public static void main(String[] args) {

        Sortable sorter = new BubbleSort();

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
