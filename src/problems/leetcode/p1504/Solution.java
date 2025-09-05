package problems.leetcode.p1504;

class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int res = 0;

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (mat[i][j] == 1) {
//                    if (j - 1 >= 0)
//                        mat[i][j] += mat[i][j - 1];
//                    if (i - 1 >= 0)
//                        mat[i][j] += mat[i - 1][j];
//                    if (i - 1 >= 0 && j - 1 >= 0 && (mat[i][j - 1] > 0 || mat[i - 1][j] > 0)) {
//                        if (Math.min(mat[i][j - 1], mat[i - 1][j]) == 0) {
//                            int k = 0;
//                            if (mat[i][j - 1] == 0) {
//                                while (i - k >= 0 && mat[i - k][j] > 0) {
//                                    k++;
//                                }
//                            } else {
//                                while (j - k >= 0 && mat[i][j - k] > 0) {
//                                    k++;
//                                }
//                            }
//                            mat[i][j] = k;
//                        } else if (Math.min(mat[i][j - 1], mat[i - 1][j])) {
//
//                        } else
//                            mat[i][j] -= mat[i - 1][j - 1];
//                    }
//                    res += mat[i][j];
//                }
//            }
//        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 0, 1, 0},
                {0, 0, 0, 1, 3, 3},
                {0, 0, 0, 2, 5, 0},
                {1, 0, 1, 4, 8, 4},
                {2, 0, 0, 0, 5, 2},
                {3, 0, 1, 1, 0, 0},
                {4, 0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1}
        };

        int sum = 0;
        for (int[] sub : nums) {
            for (int i : sub) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}