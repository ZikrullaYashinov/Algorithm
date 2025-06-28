package leetcode.p2099;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        int[] cloneNums = nums.clone();
        Arrays.sort(cloneNums);

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = n - 1; i >= n - k; i--) {
            map.put(cloneNums[i], map.getOrDefault(cloneNums[i], 0) + 1);
        }

        int[] res = new int[k];

        int i = 0;
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            if (i == k) break;
            if (count > 0) {
                res[i++] = num;
                map.put(num, count - 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSubsequence(new int[]{-1, -2, 3, 4}, 3)));
    }
}