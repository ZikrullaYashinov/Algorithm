package problems.leetcode.p0153;

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }
        return nums[left];
    }

    static void main() {
        System.out.println(new Solution().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution().findMin(new int[]{1, 2, 3, 4, 5}));
    }
}