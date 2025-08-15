package leetcode.p0013;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] v = sc.next().toCharArray();
        char[] p = sc.next().toCharArray();

        int b = 0, s = 0;

        for (int i = 0; i < 4; i++)
            if (v[i] == p[i])
                b++;

        int[] vg = new int[10];
        int[] pg = new int[10];
        for (int i = 0; i < 4; i++) {
            vg[v[i] - '0']++;
            pg[p[i] - '0']++;
        }

        for (int i = 0; i < 10; i++)
            s += Math.min(vg[i], pg[i]);

        System.out.printf("%s %s", b, s - b);
    }
}