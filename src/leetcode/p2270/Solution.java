package leetcode.p2270;

class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long startSum = 0, endSum = 0;
        for (int num: nums) {
            endSum += num;
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            startSum += nums[i];
            endSum -= nums[i];
            if (startSum >= endSum) count++;
        }
        return count;
    }
}