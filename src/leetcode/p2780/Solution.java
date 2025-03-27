package leetcode.p2780;

import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.size();
        int dominant = 0;

        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > n / 2) {
                dominant = num;
            }
            map.put(num, count);
        }

        int allDominantsCount = map.getOrDefault(dominant, 0);
        int dominantCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == dominant) {
                dominantCount++;
            }

            if (dominantCount > (i + 1) / 2 && allDominantsCount - dominantCount > (n - i - 1) / 2) {
                return i;
            }
        }
        return -1;
    }
}