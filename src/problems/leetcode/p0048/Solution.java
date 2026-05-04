package problems.leetcode.p0048;

import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                swap(matrix, i, j, j, n - i - 1);
                swap(matrix, i, j, n - i - 1, n - j - 1);
                swap(matrix, i, j, n - j - 1, i);
            }
        }
    }

    static void main() {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private void swap(int[][] arr, int i1, int j1, int i2, int j2) {
        int tmp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = tmp;
    }
}