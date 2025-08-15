package acmp.p0010;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        for (int i = -100; i <= 100; i++) {
            if (calculate(a, b, c, d, i) == 0) {
                System.out.printf("%s ", i);
            }
        }
    }

    private static long calculate(int a, int b, int c, int d, int x) {
        return d + (long) c * x + (long) b * x * x + (long) a * x * x * x;
    }
}
