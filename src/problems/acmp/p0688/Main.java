package problems.acmp.p0688;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int gx = sc.nextInt();
        int gy = sc.nextInt();
        int dx = sc.nextInt();
        int dy = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (distance(x, y, gx, gy) * 4 <= distance(x, y, dx, dy)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println("NO");
    }

    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
    }
}