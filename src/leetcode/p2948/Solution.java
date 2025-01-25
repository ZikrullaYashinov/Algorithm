package leetcode.p2948;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] numsWithIndexes = new int[n][];
        for (int i = 0; i < n; i++)
            numsWithIndexes[i] = new int[]{nums[i], i};

        Arrays.sort(numsWithIndexes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int left = 0, curValue = numsWithIndexes[0][0];
        for (int i = 0; i < n; i++) {
            int num = numsWithIndexes[i][0];
            if (num - curValue > limit) {
                f(i, left, numsWithIndexes, nums);
                left = i;
            }
            curValue = num;
        }
        f(n, left, numsWithIndexes, nums);
        return nums;
    }

    private void f(int i, int left, int[][] numsWithIndexes, int[] nums) {
        int n = i - left;
        int[] indexes = new int[n];
        for (int j = 0; j < n; j++)
            indexes[j] = numsWithIndexes[left + j][1];
        Arrays.sort(indexes);

        for (int j = left; j < i; j++)
            nums[indexes[j - left]] = numsWithIndexes[j][0];
    }
}