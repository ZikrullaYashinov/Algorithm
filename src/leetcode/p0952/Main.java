package leetcode.p0952;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (n == 0 && m == 0)
            System.out.println("0 0");
        else if (n == 0)
            System.out.println("Impossible");
        else if (m == 0)
            System.out.printf("%s %s", n, n);
        else
            System.out.printf("%s %s", Math.max(n, m), n + m - 1);
    }
}
