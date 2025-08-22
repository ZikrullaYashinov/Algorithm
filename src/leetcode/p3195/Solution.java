package leetcode.p3195;

class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int top = top(grid, n, m);
        int bottom = bottom(grid, n, m);
        int right = right(grid, n, m);
        int left = left(grid, n, m);

        return (right - left + 1) * (bottom - top + 1);
    }

    private int left(int[][] grid, int n, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 1) {
                    return i;
                }
            }
        }
        return 0;
    }

    private int bottom(int[][] grid, int n, int m) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return i;
                }
            }
        }
        return 0;
    }

    private int right(int[][] grid, int n, int m) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 1) {
                    return i;
                }
            }
        }
        return 0;
    }

    private int top(int[][] grid, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumArea(new int[][]{{0, 1, 0}, {1, 0, 1}}));
    }
}