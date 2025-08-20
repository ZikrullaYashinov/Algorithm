package acmp.p0051;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.next().length();

        int res = 1;
        for (int i = n; i > 0; ) {
            res *= i;
            i -= k;
        }

        System.out.println(res);
    }
}