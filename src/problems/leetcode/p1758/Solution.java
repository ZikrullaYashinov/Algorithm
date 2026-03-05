package problems.leetcode.p1758;

class Solution {
    public int minOperations(String s) {
        int odd = 0, even = 0;
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            if (i % 2 == 0) {
                even += b - '0';
            } else {
                odd += b - '0';
            }
        }
        int all = bytes.length;
        int a1 = all / 2 - odd + even;
        int a2 = (all + 1) / 2 - even + odd;
        return Math.min(a1, a2);
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.minOperations("01010"));
        System.out.println(solution.minOperations("101101111"));
        System.out.println(solution.minOperations("0100"));
    }
}