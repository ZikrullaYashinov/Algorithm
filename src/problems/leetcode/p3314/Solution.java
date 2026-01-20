package problems.leetcode.p3314;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] arr = new int[1024];
        for (int i = 0; i < 1000; i++)
            if (arr[i | (i + 1)] == 0)
                arr[i | (i + 1)] = i;

        int[] res = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int num = arr[nums.get(i)];
            res[i] = num == 0 ? -1 : num;
        }
        return res;
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.minBitwiseArray(List.of(2, 3, 5, 7))));
    }
}