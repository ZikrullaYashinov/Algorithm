package problems.acmp.p0900;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = n / 24;
        System.out.printf("%s %s %s", d * 13, d * 4, d * 7);
    }
}