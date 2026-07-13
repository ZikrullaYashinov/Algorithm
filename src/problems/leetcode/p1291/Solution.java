package problems.leetcode.p1291;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] src = {12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789};

        List<Integer> res = new ArrayList<>();

        for (int n : src) {
            if (n >= low && n <= high) {
                res.add(n);
            }
        }

        return res;
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(validNumber(234));
        System.out.println(generateSequential());
    }

    private static List<Integer> generateSequential() {
        List<Integer> result = new ArrayList<>();
        for (int i = 10; i <= 1_000_000_000; i++) {
            if (validNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean validNumber(int num) {
        int last = num % 10;
        do {
            num = num / 10;
            if (num > 0 && num % 10 != last - 1) {
                return false;
            }
            last = num % 10;
        } while (num != 0);
        return true;
    }
}