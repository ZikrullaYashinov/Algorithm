package rebocontest_101.d;

import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer("");

        int n = nextInt();
        int[] nums = new int[7];

        int i = 0;
        while (n > 0) {
            nums[i++] = n % 10;
            n /= 10;
        }

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        pw.println(max);

        List<Integer> list = new ArrayList<>();

        for (int j = 0; j < max; j++) {
            int num = 0;
            int m = 1;
            for (int k = 0; k < 7; k++) {
                num += (nums[k] > 0 ? 1 : 0) * m;
                m *= 10;
                if (nums[k] > 0)
                    nums[k]--;
            }
            list.add(num);
        }

        Collections.sort(list);

        for (int j = list.size() - 1; j >= 0; j--) {
            pw.print(list.get(j) + " ");
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
