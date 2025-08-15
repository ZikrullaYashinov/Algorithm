package acmp.p0763;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n == 1 && m == 1)
            System.out.println(0);
        else if (n == m)
            System.out.println(2);
        else
            System.out.println(1);
    }
}