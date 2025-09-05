package problems.leetcode.p1695;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] arr = new int[10001];

        int left = 0, right = 0;
        int sum = 0, max = 0;
        int n = nums.length;
        while (right < n) {
            int num = nums[right];
            if (arr[num] == 0) {
                arr[num]++;
                sum += num;
                right++;
            } else {
                num = nums[left];
                arr[num]--;
                sum -= num;
                left++;
            }
            if (sum > max) max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    }
}