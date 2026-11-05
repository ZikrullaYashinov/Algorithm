package problems.leetcode.p1385;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
        System.out.println(new Solution().findTheDistanceValue(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3));
        System.out.println(new Solution().findTheDistanceValue(new int[]{2, 1, 100, 3}, new int[]{-5, -2, 10, -3, 7}, 6));
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int count = 0;

        for (int val : arr1) {
            if (!existDistance(arr2, val, d)) {
                count++;
            }
        }
        return count;
    }

    private boolean existDistance(int[] arr, int val, int d) {
        int searched = search(arr, val);

        return distance(val, arr[searched]) <= d || searched > 0 && distance(val, arr[searched - 1]) <= d;
    }

    private int search(int[] arr, int val) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;

            int temp = arr[mid];
            if (temp == val) return mid;
            if (temp < val)
                start = mid + 1;
            else
                end = mid;
        }

        return end;
    }

    private int distance(int a, int b) {
        return Math.abs(a - b);
    }
}