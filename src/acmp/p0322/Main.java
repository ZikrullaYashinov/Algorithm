package acmp.p0322;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int last = 1;
        for (int i = 1; i <= n;) {
            sb.append(s.charAt(i - 1));
            int temp = i;
            i += last;
            last = temp;
        }
        System.out.println(sb);
    }
}