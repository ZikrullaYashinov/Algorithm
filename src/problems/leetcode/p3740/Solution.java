package problems.leetcode.p3740;

class Solution {
    public int minimumDistance(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] == nums[j] && nums[i] == nums[k]) {
                        int temp = abs(i, j, k);
                        if (max == -1 || temp < max) {
                            max = temp;
                        }
                    }
                }
            }
        }
        return max;
    }

    int abs(int i, int j, int k) {
        return Math.abs(i - j) + Math.abs(k - j) + Math.abs(k - i);
    }

    static void main() {

        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 2, 3, 2, 1, 2};
        System.out.println(solution.minimumDistance(nums));
    }
}