package problems.leetcode.p1015;

class Solution {
    public static int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int count = 1;
        int temp = 1;
        while (temp % k != 0) {
            temp = (temp % k) * 10 + 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestRepunitDivByK(5));
        System.out.println(solution.smallestRepunitDivByK(23));
    }
}