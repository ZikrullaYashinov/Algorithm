package problems.acmp.p0715;

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
        sc.nextLine();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char[] sub = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                if (sub[j] == arr[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
