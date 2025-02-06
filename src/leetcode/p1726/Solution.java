package leetcode.p1726;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int tupleSameProduct(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                int value = entry.getValue();
                result += 4 * value * (value - 1);
            }
        }

        return result;
    }
}