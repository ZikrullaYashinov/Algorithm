package problems.acmp.p0720;

import java.util.*;

public class Main {
    static void main() {
        Locale.setDefault(Locale.CANADA);
        var scanner = new Scanner(System.in);
        double r = scanner.nextDouble();
        int l = scanner.nextInt();
        long s = 0, n = (int) (r / l), last = 0;
        while (n > 0) {
            double v = r * r - n * l * n * l;
            if (v > 0){
                long t = (long) (Math.sqrt(v) / l);
                s += n * (t - last);
                last = t;
            }
            n--;
        }
        System.out.println(s * 4);
    }
}
