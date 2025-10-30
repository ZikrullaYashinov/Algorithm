package problems.acmp.p0165;

import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer("");

        int n = nextInt();
        int m = nextInt();

        int[][] arr = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = nextInt();
            }
        }

        pw.println(dfs(arr, n, m, 0, 0));
        pw.close();
    }

    private static int dfs(int[][] arr, int n, int m, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (i == n - 1 && j == m - 1)
            return 1;

        int count = 0;
        int val = arr[i][j];

        if (i + val < n) {
            int subCount = dfs(arr, n, m, i + val, j);
            if (subCount > 0) {
                count += subCount;
            }
        }

        if (j + val < m) {
            int subCount = dfs(arr, n, m, i, j + val);
            if (subCount > 0) {
                count += subCount;
            }
        }

        dp[i][j] = count;
        return count;
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static String next() throws IOException {
        if (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}

/*
3 3
1 1 1
1 1 1
1 1 1
 */