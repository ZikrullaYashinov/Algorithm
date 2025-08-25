package leetcode.p0498;

import java.util.Arrays;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;

        int[] arr = new int[n * m];
        boolean bottomToTop = true;
        int index = 0;
        for (int k = 0; k < n + m - 1; k++) {
            if (bottomToTop) {
                int i = x1, j = y1;
                while (i <= x2 && j >= y2) {
                    arr[index++] = mat[j][k-j];
                    i++;
                    j--;
                }
            } else {
                int i = x2, j = y2;
                while (i >= x1 && j <= y1) {
                    arr[index++] = mat[j][i];
                    i--;
                    j++;
                }
            }
            if (y1 + 1 < n) y1++;
            else x1++;
            if (x2 + 1 < m) x2++;
            else y2++;
            bottomToTop = !bottomToTop;
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}