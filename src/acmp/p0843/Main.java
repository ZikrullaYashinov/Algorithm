package acmp.p0843;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int f = sc.nextInt();
        int l = sc.nextInt();

        int passed = m + f - n + l;
        System.out.printf("%s %s %s", passed, m - passed, f - passed);
    }
}