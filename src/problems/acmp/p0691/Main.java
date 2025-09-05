package problems.acmp.p0691;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String num = scanner.next();
            boolean valid = num.length() == 6;
            for (int index : new int[]{0, 4, 5}) {
                valid = valid && isLetter(num.charAt(index));
            }
            for (int index : new int[]{1, 2, 3}) {
                valid = valid && isNum(num.charAt(index));
            }
            System.out.println(valid ? "Yes" : "No");
        }
    }

    private static boolean isNum(char ch) {
        return '0' <= ch && ch <= '9';
    }

    private static boolean isLetter(char ch) {
        char[] chars = new char[]{'A', 'B', 'C', 'E', 'H', 'K', 'M', 'O', 'P', 'T', 'X', 'Y'};
        for (char c : chars)
            if (c == ch) return true;
        return false;
    }
}
