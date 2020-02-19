package learnone.java.algorithm.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BubbleSort implements Sortable {

    int compare(int first, int second) {
        return (first == second) ? 0 : ((first > second) ? 1 : -1);
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
        for (int i = 1; i < a.length; i++) {
            sequential = true;
            for (int j = 0; j < a.length - i; j++) {
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

//        int[] unordered = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
//        int[] unordered = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3 };
        int[] unordered = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 3, 1, 4, 1, 5, 9, 2,
                6, 5, 3, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3 };
//        int[] unordered = { 9 };
//        int[] unordered = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//        int[] unordered = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Integer[] u3 = IntStream.of(unordered).boxed()
                .collect(Collectors.toList()).toArray(new Integer[0]);
        Collections.sort(Arrays.asList(u3), (i1, i2) -> {
            return i1.equals(i2) ? 0 : (i1 > i2 ? 1 : -1);
        });
        sorter.sort(unordered);
        System.out.println(Arrays.toString(unordered));
        System.out.println(Arrays.toString(u3));
    }

}
