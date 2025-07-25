package acmp.p0120;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] dp = new long[n][m];
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(minExpense(arr, dp, 0, 0, n, m));
    }


    private static long minExpense(int[][] arr, long[][] dp, int i, int j, int n, int m) {
        if (i >= n - 1 && j >= m - 1) {
            return arr[i][j];
        }

        long min = Integer.MAX_VALUE;
        if (i < n - 1) {
            long bottom;
            if (dp[i + 1][j] == 0) {
                bottom = minExpense(arr, dp, i + 1, j, n, m);
                dp[i + 1][j] = bottom;
            } else {
                bottom = dp[i + 1][j];
            }
            if (bottom < min) {
                min = bottom;
            }
        }
        if (j < m - 1) {
            long right;
            if (dp[i][j + 1] == 0) {
                right = minExpense(arr, dp, i, j + 1, n, m);
                dp[i][j + 1] = right;
            } else {
                right = dp[i][j + 1];
            }
            if (right < min) {
                min = right;
            }
        }
        return min + arr[i][j];
    }
}
