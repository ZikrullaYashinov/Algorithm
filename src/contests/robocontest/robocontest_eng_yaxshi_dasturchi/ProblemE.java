package contests.robocontest.robocontest_eng_yaxshi_dasturchi;

import java.io.*;
import java.util.*;

public class ProblemE {
    static StringTokenizer st;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer("");

        int n = nextInt();
        int m = nextInt();

        Map<Integer, Boolean> d = new HashMap<>();
        Map<Integer, HashSet<Integer>> t = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int u = nextInt();
            int v = nextInt();
            d.put(u, true);
            HashSet<Integer> hashSet = t.getOrDefault(v, new HashSet<>());
            hashSet.add(u);
            t.put(v, hashSet);
        }

        int cur = -1;
        for (int i = 1; i <= n; i++) {
            if (d.get(i) == null) {
                if (cur != -1) {
                    pw.println(-1);
                    pw.close();
                    return;
                }
                cur = i;
            }
        }

        if (cur != -1 && t.get(cur).size() == n - 1)
            pw.println(cur);
        else
            pw.println(-1);
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