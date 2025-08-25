package acmp.p0499;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int w = sc.nextInt();
        int sum = k * w;
        for (int i = 0; i < 3; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sum -= a * b;
        }
        System.out.println(sum >= 0 ? "YES" : "NO");
    }
}
