package problems.acmp.p0926;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            chars[i] = sc.next().toCharArray();
            for (int j = 0; j < n; j++)
                if (chars[i][j] == 'C')
                    count++;
        }

        int cur = 0;

        char ch = '1';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chars[i][j] == 'C')
                    cur++;
                chars[i][j] = ch;
                if (cur * 2 == count)
                    ch = '2';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}
