package leetcode.p3459;

class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (i + 1 < n && j + 1 < m && grid[i + 1][j + 1] == 2) {
                        max = Math.max(max, dfs(grid, i, j, i + 1, j + 1, 2, false, n, m));
                    }
                    if (i + 1 < n && j - 1 >= 0 && grid[i + 1][j - 1] == 2) {
                        max = Math.max(max, dfs(grid, i, j, i + 1, j - 1, 2, false, n, m));
                    }
                    if (i - 1 >= 0 && j + 1 < m && grid[i - 1][j + 1] == 2) {
                        max = Math.max(max, dfs(grid, i, j, i - 1, j + 1, 2, false, n, m));
                    }
                    if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 2) {
                        max = Math.max(max, dfs(grid, i, j, i - 1, j - 1, 2, false, n, m));
                    }
                    max = Math.max(max, 1);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int nextI, int nextJ, int distance, boolean turn, int n, int m) {
        int x = 2 * nextI - i;
        int y = 2 * nextJ - j;
        int res = distance;
        if (x >= 0 && y >= 0 && x < n && y < m && Math.abs(grid[x][y] - grid[nextI][nextJ]) == 2) {
            res = Math.max(res, dfs(grid, nextI, nextJ, x, y, distance + 1, turn, n, m));
        }

        if (turn) return res;

        if (i < nextI && j < nextJ || i > nextI && j > nextJ) {
            if (x >= 0 && x < n && Math.abs(grid[x][j] - grid[nextI][nextJ]) == 2) {
                res = Math.max(res, dfs(grid, nextI, nextJ, x, j, distance + 1, true, n, m));
            }
        }
        if (i < nextI && j > nextJ || i > nextI && j < nextJ) {
            if (y >= 0 && y < m && Math.abs(grid[i][y] - grid[nextI][nextJ]) == 2) {
                res = Math.max(res, dfs(grid, nextI, nextJ, i, y, distance + 1, true, n, m));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lenOfVDiagonal(
                new int[][]{{1, 1, 1, 2, 0, 0}, {0, 0, 0, 0, 1, 2}}));
        System.out.println(solution.lenOfVDiagonal(
                new int[][]{{1}}));
        System.out.println(solution.lenOfVDiagonal(
                new int[][]{{2, 2, 1, 2, 2}, {2, 0, 2, 2, 0}, {2, 0, 1, 1, 0}, {1, 0, 2, 2, 2}, {2, 0, 0, 2, 2}}));
    }
}

/*
[
[1,1,1,2,0,0],
[0,0,0,0,1,2]
]
 */