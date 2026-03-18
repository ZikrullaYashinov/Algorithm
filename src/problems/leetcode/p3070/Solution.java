package problems.leetcode.p3070;

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = 0;
                if (i > 0)
                    temp += grid[i - 1][j];
                if (j > 0)
                    temp += grid[i][j - 1];
                if (i > 0 && j > 0)
                    temp -= grid[i - 1][j - 1];
                temp += grid[i][j];
                grid[i][j] = temp;
                if (temp <= k)
                    res++;
            }
        }
        return res;
    }

    static void main() {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {7, 2, 9},
                {1, 5, 0},
                {2, 6, 6}
        };
        System.out.println(solution.countSubmatrices(grid, 20));
    }
}