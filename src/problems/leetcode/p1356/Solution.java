package problems.leetcode.p1356;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] sortByBits(int[] arr) {
        int[][] result = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++)
            result[i] = new int[]{arr[i], Integer.bitCount(arr[i])};

        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < result.length; i++)
            arr[i] = result[i][0];

        return arr;
    }
}