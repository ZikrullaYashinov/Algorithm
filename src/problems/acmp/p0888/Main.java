package problems.acmp.p0888;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int grade = 3;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 1) {
                res += grade;
                grade++;
            } else {
                grade = Math.max(3, grade - 3);
            }
        }
        System.out.println(res);
    }
}