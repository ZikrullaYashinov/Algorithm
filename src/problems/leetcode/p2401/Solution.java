package problems.leetcode.p2401;
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 1;
        int value = nums[0];
        int maxLength = 1;

        while (left < right) {
            if ((nums[right] & value) == 0) {
                value |= nums[right];
            } else {
                left++;
            }
            right++;
            if (right - left > maxLength) {
                maxLength = right - left;
            }

            if (right == n) return maxLength;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
        System.out.println(new Solution().longestNiceSubarray(new int[]{3, 1, 5, 11, 13}));
        System.out.println(new Solution().longestNiceSubarray(new int[]{178830999, 19325904, 844110858, 806734874, 280746028, 64, 256, 33554432, 882197187, 104359873, 453049214, 820924081, 624788281, 710612132, 839991691}));
    }
}