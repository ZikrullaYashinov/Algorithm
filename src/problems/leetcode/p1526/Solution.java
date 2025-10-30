package problems.leetcode.p1526;

class Solution {
    public int minNumberOperations(int[] target) {
        int last = 0, sum = 0;
        for (int i : target) {
            if (i > last) {
                sum += i - last;
            }
            last = i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumberOperations(new int[]{1, 2, 3, 2, 1}));
        System.out.println(solution.minNumberOperations(new int[]{3, 1, 1, 2}));
        System.out.println(solution.minNumberOperations(new int[]{3, 1, 5, 4, 2}));
    }
}