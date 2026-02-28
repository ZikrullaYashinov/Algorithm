package problems.leetcode.p1680;

class Solution {
    public int concatenatedBinary(int n) {
        long val = 0;
        for (int i = 1; i <= n; i++) {
            val = ((val << getCount(i)) + i) % 1000000007;
        }
        return (int) val;
    }

    private int getCount(int num) {
        int count = 0;
        while (num != 0) {
            num /= 2;
            count++;
        }
        return count;
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.concatenatedBinary(1));
        System.out.println(solution.concatenatedBinary(3));
        System.out.println(solution.concatenatedBinary(12));
    }
}