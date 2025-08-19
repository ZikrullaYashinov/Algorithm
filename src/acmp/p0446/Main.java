package acmp.p0446;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                int ch = arr[i][j];
                if (ch == 'B' && (num != 1 && num != 3 && num != 5 && num != 7) ||
                        ch == 'G' && (num != 2 && num != 3 && num != 6 && num != 7) ||
                        ch == 'R' && (num != 4 && num != 5 && num != 6 && num != 7)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}