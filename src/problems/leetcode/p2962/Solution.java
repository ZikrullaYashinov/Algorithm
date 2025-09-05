package problems.leetcode.p2962;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxValue = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }

        long countSubarrays = 0;
        int left = 0, right = 0, count = 0;
        while (left <= right) {
            if (count >= 2) {
                if (nums[left] == maxValue) {
                    count--;
                }
                countSubarrays += n - right + 1;
                left++;
            } else if (right < n) {
                if (nums[right] == maxValue) {
                    count++;
                }
                right++;
            } else {
                left++;
            }
        }

        if (count >= 2) {
            countSubarrays++;
        }

        return countSubarrays;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubarrays(new int[]{37, 20, 38, 66, 34, 38, 9, 41, 1, 14, 25, 63, 8, 12, 66, 66, 60, 12, 35, 27, 16, 38, 12, 66, 38, 36, 59, 54, 66, 54, 66, 48, 59, 66, 34, 11, 50, 66, 42, 51, 53, 66, 31, 24, 66, 44, 66, 1, 66, 66, 29, 54}, 5));
        System.out.println(s.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
        System.out.println(s.countSubarrays(new int[]{1, 4, 2, 1}, 3));
    }
}