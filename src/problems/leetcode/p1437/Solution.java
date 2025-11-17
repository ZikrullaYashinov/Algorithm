package problems.leetcode.p1437;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = 0;
        boolean first = true;
        for (int num : nums) {
            if (num == 0) {
                count++;
            } else {
                if (!first && count < k) {
                    return false;
                }
                first = false;
                count = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
    }
}