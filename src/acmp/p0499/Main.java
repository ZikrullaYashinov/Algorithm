package acmp.p0499;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int w = sc.nextInt();

        int[][] nums = new int[3][3];
        int sumK = 0;
        int sumW = 0;
        for (int i = 0; i < 3; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            nums[i][0] = a;
            nums[i][1] = b;

            sumK += b;
            sumW += a;

            if (k <= b && w >= a) {
                System.out.println("YES");
                return;
            }
        }

        if (k <= sumK && w >= sumW) {
            System.out.println("YES");
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (k <= nums[i][1] + nums[j][1] && w >= nums[i][0] + nums[j][0]) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }
}
