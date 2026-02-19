package problems.leetcode.p0693;

class Solution {
    public boolean hasAlternatingBits(int n) {
        int a = n % 2;
        n /= 2;
        while (n > 0) {
            if (a == (n % 2)) {
                return false;
            }
            a = n % 2;
            n /= 2;
        }
        return true;
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(10));
    }
}