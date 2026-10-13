package problems.leetcode.p3727;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int max = Math.abs(nums[0]), min = max;
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]);
            if (temp > max) max = temp;
            else if (temp < min) min = temp;
            nums[i] = temp;
        }

        int[] arr = new int[max - min + 1];

        for (int num : nums) {
            arr[num - min]++;
        }

        long sum = 0;
        int middle = nums.length / 2;

        for (int i = min; i <= max; i++) {
            if (arr[i - min] > 0) {
                if (middle >= arr[i - min]) {
                    sum -= (long) arr[i - min] * i * i;
                    middle -= arr[i - min];
                } else if (middle == 0) {
                    sum += (long) arr[i - min] * i * i;
                } else {
                    sum += (arr[i - min] - 2L * middle) * i * i;
                    middle = 0;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxAlternatingSum(new int[]{1, 2, 3}));
    }
}