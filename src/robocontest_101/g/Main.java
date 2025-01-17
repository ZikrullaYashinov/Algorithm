package robocontest_101.g;

import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer("");

        int x = nextInt();
        int y = nextInt();

        byte[] bytes = next().getBytes();

        int count = 0;
        boolean has = false;
        for (byte b : bytes) {
            if (b == '0') {
                if (!has) {
                    count++;
                    has = true;
                }
            } else
                has = false;
        }

        if (y <= x) {
            pw.println(count * y);
        } else {
            pw.println((count - 1) * x + y);
        }

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
