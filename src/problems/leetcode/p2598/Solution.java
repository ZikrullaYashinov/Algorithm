package problems.leetcode.p2598;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] arr = new int[value];
        for (int num : nums) {
            int i = num % value;
            arr[i < 0 ? i + value : i]++;
        }
        int smallest = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < smallest) {
                smallest = i;
            }
        }
        int res = smallest * value;
        for (int i = 0; i < value; i++) {
            if (arr[i] > smallest) {
                res++;
            } else {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSmallestInteger(new int[]{0, -3}, 4));
        System.out.println(solution.findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5));
    }
}