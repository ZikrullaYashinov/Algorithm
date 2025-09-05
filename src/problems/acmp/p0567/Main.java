package problems.acmp.p0567;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int count = 1;
        for (int i = 2; i < n; i++)
            if (gcd(n, i) == 1) {
                count++;
            }

        System.out.println(count);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}