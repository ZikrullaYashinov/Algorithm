package problems.leetcode.p3315;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] res = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            res[i] = execute(nums.get(i));
        }
        return res;
    }

    private int execute(int num) {
        int temp = num;
        int count = 0;
        while (temp % 2 == 1) {
            temp /= 2;
            count = count << 1;
            count++;
        }

        if (count == 1 && (num | (num - 1)) == num) return num - 1;
        if (count < 2) return -1;
        return num - count + (count >> 1);
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.minBitwiseArray(List.of(11, 13, 31))));
        System.out.println(Arrays.toString(solution.minBitwiseArray(List.of(2, 3, 5, 7))));
    }
}
