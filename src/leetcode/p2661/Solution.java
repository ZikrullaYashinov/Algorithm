package leetcode.p2661;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int len = arr.length;
        int n = mat.length;
        int m = mat[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        int[][] arrWithIndexes = new int[len + 1][];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arrWithIndexes[mat[i][j]] = new int[]{i, j};

        for (int i = 0; i < len; i++) {
            int[] indexes = arrWithIndexes[arr[i]];
            if (++row[indexes[0]] == m || ++col[indexes[1]] == n)
                return i;
        }

        return len - 1;
    }
}