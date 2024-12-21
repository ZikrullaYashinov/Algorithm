package leetcode.p769;

import java.util.Arrays;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] positions = new int[11];

        for (int i = 0; i < n; i++) {
            positions[arr[i]] = i;
        }

        Arrays.sort(arr);

        int count = 0, right = 0;
        for (int i = 0; i < n; i++) {
            int pos = positions[i];
            if (pos > right)
                right = pos;
            if (i >= right) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(new Solution().maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }
}
