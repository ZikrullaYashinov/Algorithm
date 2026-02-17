package problems.leetcode.p0190;

class Solution {
    public int reverseBits(int n) {
        StringBuilder reverse = new StringBuilder(Integer.toBinaryString(n)).reverse();
        int need = 32 - reverse.length();
        while (need-- > 0) {
            reverse.append('0');
        }
        return Integer.parseInt(reverse.toString(), 2);
    }
}