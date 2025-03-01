package leetcode.p2460;

import java.util.Arrays;

class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int index = 0;
        int[] res = new int[n];

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    nums[i + 1] = 0;
                    res[index++] = nums[i] * 2;
                } else
                    res[index++] = nums[i];
            }
        }

        if (nums[n - 1] != 0) {
            res[index] = nums[n - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.applyOperations(new int[]{312, 312, 436, 892, 0, 0, 528, 0, 686, 516, 0, 0, 0, 0, 0, 445, 445, 445, 445, 445, 445, 984, 984, 984, 0, 0, 0, 0, 168, 0, 0, 647, 41, 203, 203, 241, 241, 0, 628, 628, 0, 875, 875, 0, 0, 0, 803, 803, 54, 54, 852, 0, 0, 0, 958, 195, 590, 300, 126, 0, 0, 523, 523})));
        System.out.println(Arrays.toString(solution.applyOperations(new int[]{0, 1})));
        System.out.println(Arrays.toString(solution.applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
    }
}