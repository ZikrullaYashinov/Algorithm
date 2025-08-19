package acmp.p0794;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        if (k == 1) {
            System.out.println(m * n);
        } else {
            int count = m / k;
            if (k <= m)
                count += k - 1;
            else
                count += m;
            System.out.println(count * n);
        }

    }
}