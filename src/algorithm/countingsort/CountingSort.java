package algorithm.countingsort;

import java.util.Arrays;

public class CountingSort {
    public int[] sort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }

        int[] counts = new int[max - min + 1];
        for (int value : arr) counts[value - min]++;

        int[] sorted = new int[arr.length];
        int pos = 0;
        for (int i = 0; i < counts.length; i++)
            for (int k = 0; k < counts[i]; k++)
                sorted[pos++] = i + min;
        return sorted;
    }
}

class CountingSortTest {
    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] arr = new int[]{5, 4, 3, 2, 1, 83, 10};
        int[] sorted = countingSort.sort(arr);
        System.out.println(Arrays.toString(sorted));
    }
}