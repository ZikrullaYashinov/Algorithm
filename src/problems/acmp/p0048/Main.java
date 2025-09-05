package problems.acmp.p0048;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int zeroCount = 0;
        for (int i = n.length() - 1; i > 0 && n.charAt(i) == '0'; i--) {
            zeroCount++;
        }
        StringBuilder sb = new StringBuilder().append('1');
        for (int i = 0; i < zeroCount; i++) {
            sb.append('0');
        }
        System.out.println(sb);
    }
}
