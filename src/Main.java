import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer("");

        int n = nextInt();
        int q = nextInt();

        List<Map<Integer, Integer>> d = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();

        d.add(new HashMap<>()); // d[0]
        for (int i = 1; i <= n; i++) {
            int a = nextInt();
            m.put(a, m.getOrDefault(a, 0) + 1);
            d.add(new HashMap<>(m));
        }

        for (int i = 0; i < q; i++) {
            int l = nextInt();
            int r = nextInt();

            Map<Integer, Integer> m1 = d.get(l - 1);
            Map<Integer, Integer> m2 = d.get(r);

            int count = 0;

            for (Map.Entry<Integer, Integer> entry : m2.entrySet()) {
                if (entry.getValue() - m1.getOrDefault(entry.getKey(), 0) == 2) {
                    count++;
                }
            }

            pw.println(count);
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
