package problems.acmp.p0700;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int k = sc.nextInt();
        long tempK = k;
        long sum = v;
        n--;
        while (n > 0 && v > tempK) {
            sum += v - tempK;
            tempK += k;
            n--;
        }
        System.out.printf("%s %s", n > 0 ? "NO" : "YES", sum);
    }
}
