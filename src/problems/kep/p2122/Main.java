package problems.kep.p2122;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer("");

        int n = nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i] += nextInt();
            }
        }

        Arrays.sort(arr);

        out.println(arr[n - 1] == arr[n - 2] ? "No" : "Yes");

        out.close();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

}
