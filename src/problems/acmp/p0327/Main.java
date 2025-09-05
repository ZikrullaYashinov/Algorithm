package problems.acmp.p0327;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println("Yes");
            return;
        }
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            System.out.println(isHappy(num - 1) || isHappy(num + 1) ? "Yes" : "No");
        }
    }

    private static boolean isHappy(int num) {
        int part1 = 0, part2 = 0;
        for (int i = 0; i < 3; i++) {
            part1 += num % 10;
            num /= 10;
        }
        for (int i = 0; i < 3; i++) {
            part2 += num % 10;
            num /= 10;
        }
        return part1 == part2;
    }
}
