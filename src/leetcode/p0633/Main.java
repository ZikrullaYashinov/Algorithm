package leetcode.p0633;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(sc.nextLine()).append(": ");
        String[] names = new String[3];
        for (int i = 0; i < 3; i++) {
            names[i] = sc.nextLine();
        }
        Arrays.sort(names);

        sb.append(names[0]).append(", ");
        sb.append(names[1]).append(", ");
        sb.append(names[2]);

        System.out.println(sb);
    }
}