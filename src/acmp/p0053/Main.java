package acmp.p0053;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int divided2 = 0;
        int divided3 = 0;
        int divided5 = 0;
        int dividedDefault = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int num = i * j;
                if (num % 5 == 0)
                    divided5++;
                else if (num % 3 == 0)
                    divided3++;
                else if (num % 2 == 0)
                    divided2++;
                else
                    dividedDefault++;
            }
        }

        System.out.printf("RED : %s\n", divided2);
        System.out.printf("GREEN : %s\n", divided3);
        System.out.printf("BLUE : %s\n", divided5);
        System.out.printf("BLACK : %s\n", dividedDefault);
    }
}