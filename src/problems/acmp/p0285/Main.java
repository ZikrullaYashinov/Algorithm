package problems.acmp.p0285;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = sc.nextInt();
        int min = sum;
        for (int i = 1; i < n; i++) {
            int cur= sc.nextInt();
            min = Math.max(min, cur);
            sum += cur - 1;
        }
        if (sum >= m && m >= min) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
