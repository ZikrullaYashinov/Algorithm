package algorithm.mergesort;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] arr) {
        divide(arr, 0, arr.length - 1);
    }

    private void divide(int[] arr, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;

        divide(arr, left, mid);
        divide(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int aPos = left;
        int bPos = mid + 1;
        int pos = 0;

        while (aPos <= mid && bPos <= right) {
            if (arr[aPos] < arr[bPos])
                temp[pos++] = arr[aPos++];
            else
                temp[pos++] = arr[bPos++];
        }

        while (aPos <= mid)
            temp[pos++] = arr[aPos++];

        while (bPos <= right)
            temp[pos++] = arr[bPos++];

        for (int i = left; i <= right; i++)
            arr[i] = temp[i - left];
    }
}

class MergeSortTest {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = new int[]{5, 4, 3, 2, 1, 51, 10};
        ms.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}