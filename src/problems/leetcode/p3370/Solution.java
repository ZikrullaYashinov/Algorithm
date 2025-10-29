package problems.leetcode.p3370;

class Solution {
    public int smallestNumber(int n) {
        int len = 0;
        while (n != 0) {
            n = n / 2;
            len++;
        }
        return (1 << len) - 1;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestNumber(5));
    }
}