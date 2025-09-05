package problems.leetcode.p0594;

import java.util.Arrays;

class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = 0;
        int res = 0;
        int count = 0;
        while (right < nums.length){
            int l = nums[left];
            int r = nums[right];
            if (r - l == 1) {
                count++;
                right++;
                if (count > res) res = count;
            } else if (r - l > 1) {
                left++;
                count = 0;
                right = left;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLHS(new int[]{-1, 0, -1, 0, -1, 0, -1}));
        System.out.println(solution.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }
}