package problems.acmp.p0101;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CANADA);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[][] arr = new boolean[n][n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += f(arr, i, j, 1, k, n);
            }
        }
        System.out.println(count);
    }

    private static int f(boolean[][] arr, int i, int j, int count, int k, int n) {
        arr[i][j] = true;

        fillMoves(arr, i, j, n);

        if (k == count + 1) {
            return countFalse(arr, n



            );
        }

        int res = 0;
        for (int l = 0; l < n; l++) {
            for (int m = 0; m < n; m++) {
                if (arr[l][m]) {
                    res += f(arr, l, m, count + 1, k, n);
                }
            }
        }
        return res;
    }

    private static void fillMoves(boolean[][] arr, int i, int j, int n) {
        for (int l = 0; l < n; l++) {
            for (int m = 0; m < n; m++) {
                if (!arr[l][m]) {
                    arr[l][m] = Math.abs(i - l) == 2 && Math.abs(j - m) == 1
                            || Math.abs(i - l) == 1 && Math.abs(j - m) == 2
                            || i == l || j == m || i - l == j - m;
                }
            }
        }
    }

    private static int countFalse(boolean[][] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!arr[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
