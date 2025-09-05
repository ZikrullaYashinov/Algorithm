package problems.leetcode.p2200;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int startIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int j = Math.max(startIndex, i - k); j <= Math.min(nums.length - 1, i + k); j++) {
                    res.add(j);
                }
                startIndex = i + k + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKDistantIndices(new int[]{2, 2, 2, 2, 2}, 2, 2));
        System.out.println(solution.findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1));
        System.out.println(solution.findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1));
    }
}