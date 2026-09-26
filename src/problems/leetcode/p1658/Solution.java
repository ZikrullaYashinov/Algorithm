package problems.leetcode.p1658;

class Solution {
    void main() {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(solution.minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println(solution.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
        System.out.println(solution.minOperations(new int[]{3, 1, 1, 2, 1, 1, 1}, 5));
    }

    public int minOperations(int[] nums, int x) {
        long[][] arr = new long[nums.length][2];

        long sum = nums[0];
        arr[0] = new long[]{x - sum, 1};
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            arr[i] = new long[]{x - sum, i + 1};
        }

        sum = 0;

        int predictIndex = nums.length - 1;
        int min = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int count = find(arr, sum, nums.length - 1 - i, predictIndex);
            if (count != -1 && (min == -1 || min > count)) {
                min = count;
            }
            sum += nums[i];
            arr[i] = new long[]{x - sum, i + 1};
        }

        return min;
    }

    private int find(long[][] arr, long target, int count, int predictIndex) {
        long[] predict = arr[predictIndex];
        while (predict[0] <= target && predictIndex > 0) {
            if (predict[0] == target) {
                return (int) (count + predict[1]);
            }
            predict = arr[--predictIndex];
        }
        return -1;
    }
}

