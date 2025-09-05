package problems.leetcode.p2016;

class Solution {
    public int maximumDifference(int[] nums) {
        int maxDifference = -1;
        int n = nums.length;
        int left = 0, right = 1;

        while (left < right && right < n) {
            int dif = nums[right] - nums[left];

            if (dif < 0) {
                left = right;
            }
            right++;

            if (dif > maxDifference) {
                maxDifference = dif;
            }
        }

        return maxDifference > 0 ? maxDifference : -1;
    }
}