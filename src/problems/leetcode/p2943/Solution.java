package problems.leetcode.p2943;

import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxH = maxSubCount(hBars);
        int maxV = maxSubCount(vBars);
        return (int) Math.pow(Math.min(maxH, maxV) + 1, 2);
    }

    private int maxSubCount(int[] arr) {
        int max = 1;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                count++;
            } else {
                if (count > max) max = count;
                count = 1;
            }
        }
        return Math.max(count, max);
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.maximizeSquareHoleArea(3, 2, new int[]{3, 2, 4}, new int[]{3, 2}));
        System.out.println(solution.maximizeSquareHoleArea(2, 1, new int[]{2, 3}, new int[]{2}));
    }
}