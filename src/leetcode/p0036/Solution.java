package leetcode.p0036;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] row = new int[9];
            int[] col = new int[9];
            for (int j = 0; j < 9; j++)
                if (inValid(row, board[i][j]) || inValid(col, board[j][i]))
                    return false;

            int x = i % 3 * 3;
            int y = i / 3 * 3;
            int[] sub = new int[9];
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    if (inValid(sub, board[x + j][y + k]))
                        return false;
        }
        return true;
    }

    private boolean inValid(int[] row, char c) {
        if (c != '.') {
            row[c - '1']++;
            return row[c - '1'] > 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }
}