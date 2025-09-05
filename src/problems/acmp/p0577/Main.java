package problems.acmp.p0577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[10];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int num = i * j;
                while (num > 0) {
                    arr[num % 10]++;
                    num /= 10;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }

    }
}