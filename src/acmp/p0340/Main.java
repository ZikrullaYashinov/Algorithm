package acmp.p0340;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] b1 = new int[3];
        int[] b2 = new int[3];

        for (int i = 0; i < 3; i++)
            b1[i] = sc.nextInt();

        for (int i = 0; i < 3; i++)
            b2[i] = sc.nextInt();

        Arrays.sort(b1);
        Arrays.sort(b2);

        if (b1[0] == b2[0] && b1[1] == b2[1] &&b1[2] == b2[2])
            System.out.println("Boxes are equal");
        else if (b1[0] >= b2[0] && b1[1] >= b2[1] && b1[2] >= b2[2])
            System.out.println("The first box is larger than the second one");
        else if (b1[0] <= b2[0] && b1[1] <= b2[1] && b1[2] <= b2[2])
            System.out.println("The first box is smaller than the second one");
        else
            System.out.println("Boxes are incomparable");
    }
}