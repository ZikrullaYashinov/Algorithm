package acmp.p0457;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if (num == 6174) {
            System.out.println("6174\n0");
            return;
        }

        int step = 0;
        do {
            num = difference(num);
            step++;
        } while (num != difference(num));

        System.out.println(num);
        System.out.println(step);
    }

    private static int difference(int num) {
        int[] array = toArray(num);
        Arrays.sort(array);

        return collect(reverse(array)) - collect(array);
    }

    private static int[] toArray(int num) {
        int[] digits = new int[4];
        int i = 4;
        while (num > 0) {
            digits[--i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    private static int collect(int[] digits) {
        int res = 0, k = 1;
        for (int j = digits.length - 1; j >= 0; j--) {
            res += digits[j] * k;
            k *= 10;
        }
        return res;
    }

    private static int[] reverse(int[] arr) {
        int[] res = new int[arr.length];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            res[i] = arr[n - i - 1];
        }
        return res;
    }
}