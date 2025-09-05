package problems.leetcode.p2017;

class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        if (n == 1)
            return 0;

        long suffixSum = 0;
        for (int i = 1; i < n; i++)
            suffixSum += grid[0][i];

        long prefixSum = 0;

        long minSum = suffixSum;
        for (int i = 1; i < n; i++) {
            prefixSum += grid[1][i - 1];
            suffixSum -= grid[0][i];
            long maxSum = Math.max(prefixSum, suffixSum);
            if (maxSum < minSum)
                minSum = maxSum;
        }

        return minSum;
    }
}