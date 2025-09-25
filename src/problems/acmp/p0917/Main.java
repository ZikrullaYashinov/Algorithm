package problems.acmp.p0917;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CANADA);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        double sum = 0;
        double a = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            double b = arr[i];
            double c = findThirdSide(a, b);
            sum += area(a, b, c);
            a = c;
        }

        System.out.printf("%.2f",sum);
    }

    private static double findThirdSide(double a, double b) {
        double left = Math.abs(a - b) + 0.01;
        double right = Math.abs(a + b);
        double maxArea = area(a, b, left);
        double c = left;
        while (left < right) {
            double curArea = area(a, b, left);
            if (curArea > maxArea) {
                maxArea = curArea;
                c = left;
            }
            left += 0.01;
        }
        return c;
    }

    private static double area(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
