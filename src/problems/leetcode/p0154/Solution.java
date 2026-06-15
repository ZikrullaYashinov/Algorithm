package problems.leetcode.p0154;

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return findMin(nums, 0, n - 1);
    }

    public int findMin(int[] nums, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[mid]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                return Math.min(findMin(nums, left, mid - 1), findMin(nums, mid + 1, right));
            }
        }

        return Math.min(nums[left], nums[0]);
    }

    static void main() {
        System.out.println(new Solution().findMin(new int[]{2, 2, 2, 0, 2, 2}));
        System.out.println(new Solution().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new Solution().findMin(new int[]{10, 1, 10, 10, 10}));
        System.out.println(new Solution().findMin(new int[]{3, 1}));
        System.out.println(new Solution().findMin(new int[]{3, 3, 1, 3}));
        System.out.println(new Solution().findMin(new int[]{1, 1, 2, 3, 4, 4, 5}));
    }
}