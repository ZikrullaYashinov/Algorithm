package leetcode.p3105;

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 1, len = 1, lenDesc = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
            } else {
                if (len > maxLen) {
                    maxLen = len;
                }
                len = 1;
            }
            if (nums[i] < nums[i - 1]) {
                lenDesc++;
            } else {
                if (lenDesc > maxLen) {
                    maxLen = lenDesc;
                }
                lenDesc = 1;
            }
        }
        if (len > maxLen) {
            maxLen = len;
        }
        if (lenDesc > maxLen) {
            maxLen = lenDesc;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestMonotonicSubarray(new int[]{1, 4, 3, 3, 2}));
    }
}