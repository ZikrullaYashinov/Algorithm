package problems.leetcode.p1009;

class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int c = 0;
        int temp = n;
        while (temp > 0) {
            c++;
            temp /= 2;
        }
        return ((1 << c) - 1) ^ n;
    }
}