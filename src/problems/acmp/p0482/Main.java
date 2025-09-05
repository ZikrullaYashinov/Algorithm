package problems.acmp.p0482;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(f(n));
    }

    private static int f(int n) {
        int i = 1, g = 1;
        while (true) {
            for (int j = 1; j <= i; j++) {
                for (char c : String.valueOf(j).toCharArray()) {
                    if (g == n) {
                        return c - '0';
                    }
                    g++;
                }
            }
            i++;
        }
    }
}
