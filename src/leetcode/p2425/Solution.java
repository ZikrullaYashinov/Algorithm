package leetcode.p2425;

class Solution {
    public int xorAllNums(int[] num1, int[] num2) {
        int n1 = num1.length;
        int n2 = num2.length;

        int res = 0;

        if (n1 % 2 == 1) {
            for (int num : num2)
                res ^= num;
        }
        if (n2 % 2 == 1) {
            for (int num : num1)
                res ^= num;
        }

        return res;
    }
}