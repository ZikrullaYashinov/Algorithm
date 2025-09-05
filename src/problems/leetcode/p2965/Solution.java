package problems.leetcode.p2965;

import java.util.Arrays;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        boolean[] arr = new boolean[2501];
        int n = grid.length;
        int a = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[grid[i][j]]) {
                    a = grid[i][j];
                } else {
                    arr[grid[i][j]] = true;
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                return new int[]{a, i};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})));
    }
}