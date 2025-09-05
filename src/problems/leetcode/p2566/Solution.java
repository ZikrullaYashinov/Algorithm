package problems.leetcode.p2566;

class Solution {
    public int minMaxDifference(int num) {
        int numCopy = num;
        int n = 1 + (int) Math.log10(num);
        int[] digits = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }

        int i = 0;
        while (i < n && digits[i] == 9) {
            i++;
        }

        int max = i == n ? numCopy : f(digits, digits[i], 9);
        int min = f(digits, digits[0], 0);

        return max - min;
    }

    private int f(int[] digits, int from, int to) {
        int res = 0;
        int pos = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            res += pos * (digits[i] == from ? to : digits[i]);
            pos *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMaxDifference(99999));
        System.out.println(solution.minMaxDifference(11891));
    }
}