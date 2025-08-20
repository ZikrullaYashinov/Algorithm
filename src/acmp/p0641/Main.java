package acmp.p0641;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr = sc.next().toCharArray();
        int n = arr.length;

        StringBuilder sb = new StringBuilder();

        int remove = 2;

        for (int i = 0; i < n - remove; i++) {
            if (remove > 0 && i + 1 < n && arr[i] < arr[i + 1]) {
                remove--;
            } else if (remove == 2 && i + 2 < n && arr[i] < arr[i + 2]) {
                remove -= 2;
                i++;
            } else {
                sb.append(arr[i]);
            }
        }

        System.out.println(sb);
    }
}