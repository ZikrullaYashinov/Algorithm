package problems.leetcode.p2553;

import java.util.Arrays;

class Solution {
    public int[] separateDigits(int[] nums) {
        int size = 0;
        for (int num : nums) {
            size += countOfDigit(num);
        }

        int[] result = new int[size];
        int index = 0;
        for (int num : nums) {
            int count = countOfDigit(num);

            int i = 0;
            while (num > 0) {
                result[index + count - i - 1] = num % 10;
                num /= 10;
                i++;
            }

            index += count;
        }

        return result;
    }

    static void main() {
        Solution solution = new Solution();
        int[] result = solution.separateDigits(new int[]{13, 25, 83, 77});
        System.out.println(Arrays.toString(result));
    }

    private int countOfDigit(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}