package problems.acmp.p0493;

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

        int[] directions = {0, 0, -1, 0, 1, 0};

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '*') {
                    for (int k = 0; k < 5; k++) {
                        int x = i + directions[k];
                        int y = j + directions[k + 1];
                        if (0 <= x && x < n && 0 <= y && y < m)
                            visited[x][y] = true;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}