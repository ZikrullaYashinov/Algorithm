package acmp.p0077;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(solve(n, m));
    }

    private static int solveByFarmer(int n, int m) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int a = Integer.toBinaryString(i).length() - Integer.bitCount(i);
            if (a == m) {
                res++;
            }
        }
        return res;
    }

    private static int solve(int n, int m) {
        int res = 0;
        char[] bit = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < bit.length && bit.length >= m; i++) {
            if (bit[i] == '1') {
                res += (int) combination(m, bit.length - i - 2);
            }
        }
        return res;
    }

    private static long combination(int m, int n) {
        long res = 1;
        for (int i = m + 1; i <= n; i++) {
            res *= i;
        }
        for (int i = 1; i <= n - m; i++) {
            res /= i;
        }
        return res;
    }
}
