package problems.leetcode.p0912;

import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int val : nums) {
            if (val < min) min = val;
            if (val > max) max = val;
        }

        int range = max - min + 1;

        int[] arr = new int[range];
        for (int num : nums) {
            arr[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < range; i++) {
            int count = arr[i];
            for (int j = 0; j < count; j++) {
                nums[index++] = i + min;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(s.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}