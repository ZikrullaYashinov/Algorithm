package acmp.p0925;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (q == 1) {
            int aq = n - a;
            int bq = n - b;

            int res = c - aq - bq;
            System.out.println(Math.max(res, 0));
        } else {
            System.out.println(Math.min(a, Math.min(b, c)));
        }
    }
}
