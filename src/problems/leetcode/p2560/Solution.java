package problems.leetcode.p2560;

class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int min = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) max = nums[i];
            else if (nums[i] < min) min = nums[i];
        }

        int med;
        int maxNum = 0;

        while (min <= max) {
            med = (min + max) / 2;

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= med) {
                    count++;
                    if (nums[i] > maxNum) {
                        maxNum = nums[i];
                    }
                    i++;
                }
            }

            if (count < k) {
                min = med + 1;
            } else {
                max = med - 1;
            }
        }

        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCapability(new int[]{2, 3, 5, 9}, 2));
        System.out.println(new Solution().minCapability(new int[]{2, 7, 9, 3, 1}, 2));
    }
}