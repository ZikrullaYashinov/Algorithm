package problems.leetcode.p0799;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 2][];
        for (int i = 0; i < query_row + 2; i++) {
            dp[i] = new double[i + 1];
        }

        pour(dp, 0, 0, query_row + 2, poured);

        return dp[query_row][query_glass];
    }

    private void pour(double[][] dp, int row, int col, int rowCount, double pouredVolume) {
        double volume = dp[row][col];

        volume += pouredVolume;

        if (volume <= 1) {
            dp[row][col] = volume;
            return;
        }

        dp[row][col] = 1;
        volume -= 1;

        if (row + 1 >= rowCount)
            return;

        pour(dp, row + 1, col, rowCount, volume / 2);
        pour(dp, row + 1, col + 1, rowCount, volume / 2);
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.champagneTower(25, 6, 1));
        System.out.println(solution.champagneTower(100000009, 33, 17));
        System.out.println(solution.champagneTower(2, 1, 1));
        System.out.println(solution.champagneTower(1, 1, 1));
    }
}