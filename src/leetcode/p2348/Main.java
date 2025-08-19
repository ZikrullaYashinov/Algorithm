package leetcode.p2348;

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (num == 0) count++;
            else {
                res += count * (count + 1) / 2;
                count = 0;
            }
        }
        return res;
    }
}