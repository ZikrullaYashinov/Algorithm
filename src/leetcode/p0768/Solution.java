package leetcode.p0768;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[][] positions = new int[n][2];

        for (int i = 0; i < n; i++)
            positions[i] = new int[]{arr[i], i};

        Arrays.sort(positions, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int count = 0, right = 0;
        for (int i = 0; i < n; i++) {
            int pos = positions[i][1];
            if (pos > right)
                right = pos;
            if (i >= right)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
        System.out.println(solution.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(solution.maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
    }
}

/*
4,3,2,1,0
1,0,2,3,4
0 1 2 3 4
 */