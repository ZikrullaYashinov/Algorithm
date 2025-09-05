package problems.acmp.p0706;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(Math.round(r * Math.abs(x) / (2.0 * r - y) * 100) / 100.0);
    }
}