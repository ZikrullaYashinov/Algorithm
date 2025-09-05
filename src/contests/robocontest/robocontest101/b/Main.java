package contests.robocontest.robocontest101.b;

import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer("");

        int n = nextInt();
        int m = nextInt();
        int k = nextInt();

        boolean[][] arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) == '.';
            }
        }

        if (k == 1) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j]) {
                        count++;
                    }
                }
            }
            pw.println(count);
            pw.close();
            return;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j]) {
                    count++;
                } else {
                    if (count >= k)
                        res += count - k + 1;
                    count = 0;
                }
            }
            if (count >= k)
                res += count - k + 1;
        }
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j][i]) {
                    count++;
                } else {
                    if (count >= k)
                        res += count - k + 1;
                    count = 0;
                }
            }
            if (count >= k)
                res += count - k + 1;
        }

        pw.println(res);
        pw.close();
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
