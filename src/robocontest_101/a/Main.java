package robocontest_101.a;

import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer("");

        long n = nextLong();
        long numMax = n;
        int[] arr = new int[19];
        int i = 0;
        while (n > 0) {
            arr[i++] = (int) n % 10;
            n /= 10;
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        sum -= arr[0];

        int maxSum = sum;

        for (int j = 1; j < 19; j++) {
            if (arr[j] > 0) {
                int x = sum - 1 + 9 * j;
                int k = (int) Math.pow(10, j);
                int numX = k - 1;
                if (x >= maxSum) {
                    maxSum = x;
                    numX += (sum - 1) * k;
                    for (int l = j + 2; l < 19; l++) {
                        numX += arr[l];
                    }
                    numMax = numX;
                }
                sum -= arr[j];
            }
        }

        pw.println(numMax);

        pw.close();
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
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
