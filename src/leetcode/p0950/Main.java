package leetcode.p0950;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s = sc.next().toCharArray();

        int prefixZero = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            if (c == '0')
                prefixZero++;
            else {
                sb.append((char) ('a' + prefixZero));
                prefixZero = 0;
            }
        }

        System.out.println(sb);
    }
}