package acmp.p0246;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int last = sc.nextInt();
        for (int i = 1; i < n; i++) {
            int num = sc.nextInt();
            if (num - last != 1)
                count++;
            last = num;
        }
        System.out.println(count);
    }
}
