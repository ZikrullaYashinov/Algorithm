package problems.leetcode.p3212;

class Cell {
    int countX;
    int countY;

    public Cell(int countX, int countY) {
        this.countX = countX;
        this.countY = countY;
    }

    public void plus(Cell other) {
        countX += other.countX;
        countY += other.countY;
    }

    public void minus(Cell other) {
        countX -= other.countX;
        countY -= other.countY;
    }
}

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Cell[][] dp = new Cell[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Cell temp = new Cell(0, 0);
                if (grid[i][j] == 'X')
                    temp.countX++;
                if (grid[i][j] == 'Y')
                    temp.countY++;
                if (i > 0) temp.plus(dp[i - 1][j]);
                if (j > 0) temp.plus(dp[i][j - 1]);
                if (i > 0 && j > 0) temp.minus(dp[i - 1][j - 1]);
                dp[i][j] = temp;

                if (temp.countX > 0 && temp.countX == temp.countY)
                    res++;
            }
        }
        return res;
    }

    static void main() {
        Solution solution = new Solution();
        char[][] grid = {
                {'X', 'Y', '.'},
                {'Y', '.', '.'},
        };
        System.out.println(solution.numberOfSubmatrices(grid));
    }
}