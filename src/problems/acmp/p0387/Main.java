package problems.acmp.p0387;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String[] arg = sc.next().split("->");
            if (arg[1].startsWith(arg[0]))
                count++;
        }

        System.out.println(count);
    }
}