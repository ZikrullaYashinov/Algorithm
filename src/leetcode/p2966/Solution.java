package leetcode.p2966;

import java.util.Arrays;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] res = new int[n / 3][];

        sort(nums);

        int i = 0;
        int[] sub = new int[3];

        while (i < n) {
            sub[i % 3] = nums[i];

            if (i % 3 == 2) {
                if (nums[i] - nums[i - 2] > k) {
                    return new int[0][];
                }
                res[i / 3] = sub;
                sub = new int[3];
            }
            i++;
        }

        return res;
    }

    private void sort(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        int[] arr = new int[max - min + 1];

        for (int num : nums) {
            arr[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                nums[index++] = i + min;
            }
        }
    }
}