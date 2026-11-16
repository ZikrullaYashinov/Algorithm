package problems.leetcode.p2747;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        Arrays.sort(queries);

        int[] arr = new int[queries.length];

        int left = 0;

        // Sliding window

        return arr;
    }
}