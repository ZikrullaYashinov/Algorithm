package problems.leetcode.p3507;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int last = nums[0];
        int cur = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            cur += nums[i];
            if (cur < last) {
                count++;
            } else {
                last = cur;
                cur = 0;
            }
        }
        return count;
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.minimumPairRemoval(new int[]{2, 2, -1, 3, -2, 2, 1, 1, 1, 0, -1}));
        System.out.println(solution.minimumPairRemoval(new int[]{2, 2, -1, 3, -2, 2, 1, 1}));
    }
}